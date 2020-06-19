package son.ysy.photo.service.user

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import son.ysy.photo.ext.hideWord
import son.ysy.photo.mapper.*
import son.ysy.photo.model.tables.POJOImageInfo
import son.ysy.photo.model.tables.POJORelationshipInfo
import son.ysy.photo.model.tables.POJOUserInfo
import son.ysy.photo.model.response.ResponseUserInfo
import son.ysy.photo.model.vo.UserUploadRecordVo
import son.ysy.photo.property.QiNiuProperty
import son.ysy.photo.throwables.login.UserNotRegisterException
import javax.annotation.Resource

@Service
class UserInfoServiceImpl : IUserInfoService {

    @Resource
    private lateinit var userInfoMapper: UserInfoMapper

    @Resource
    private lateinit var relationshipMapper: RelationshipMapper

    @Resource
    private lateinit var imageInfoMapper: ImageInfoMapper

    @Resource
    private lateinit var userUploadMapper: UserUploadMapper

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

    override fun getUploadRecord(page: Page<*>, userId: String): Page<UserUploadRecordVo> {
        return userUploadMapper.selectUserUploadRecord(page, userId)
    }
}