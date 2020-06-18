package son.ysy.photo.service.user

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import son.ysy.photo.ext.hideWord
import son.ysy.photo.mapper.*
import son.ysy.photo.model.pojo.POJOImageInfo
import son.ysy.photo.model.pojo.POJORelationshipInfo
import son.ysy.photo.model.pojo.POJOUserInfo
import son.ysy.photo.model.response.ResponseUserInfo
import son.ysy.photo.property.QiNiuProperty
import son.ysy.photo.throwables.login.UserNotRegisterException

@Service
class UserInfoServiceImpl : IUserInfoService {

    @Autowired
    private lateinit var userInfoMapper: UserInfoMapper

    @Autowired
    private lateinit var relationshipMapper: RelationshipMapper

    @Autowired
    private lateinit var imageInfoMapper: ImageInfoMapper

    @Autowired
    private lateinit var qiNiuProperty: QiNiuProperty


    override fun getUserInfo(userId: String) = runBlocking {
        val userInfo = userInfoMapper.selectOne(
                QueryWrapper<POJOUserInfo>()
                        .eq(DatabaseTables.Common.FIELD_ID, userId)
        ) ?: throw UserNotRegisterException()

        val avatarUrlDeferred = async(Dispatchers.IO) {
            (userInfo.avatarId
                    ?.run {
                        imageInfoMapper.selectOne(QueryWrapper<POJOImageInfo>().eq(DatabaseTables.Common.FIELD_ID, userInfo.avatarId))
                                ?.imageUrl
                    } ?: qiNiuProperty.defaultAvatar
                    ).run {
                        qiNiuProperty.encodeImageUrl(this)
                    }
        }

        val relationshipDeferred = async(Dispatchers.IO) {
            userInfo.relationshipId?.run {
                relationshipMapper.selectOne(
                        QueryWrapper<POJORelationshipInfo>()
                                .eq(DatabaseTables.Common.FIELD_ID, this)
                )?.relationship
            }
        }
        val relationship = relationshipDeferred.await()
        val avatarUrl = avatarUrlDeferred.await()
        ResponseUserInfo(avatarUrl, userInfo.phone.hideWord(3, 4), relationship)
    }
}