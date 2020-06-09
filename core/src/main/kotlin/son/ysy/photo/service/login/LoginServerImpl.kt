package son.ysy.photo.service.login

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import son.ysy.photo.mapper.DatabaseTables
import son.ysy.photo.mapper.UserInfoMapper
import son.ysy.photo.model.pojo.POJOUserInfo
import son.ysy.photo.model.response.ResponseLoginToken
import son.ysy.photo.throwables.NoUserException
import son.ysy.photo.throwables.OtherUserHasLoginException

@Service
class LoginServerImpl : ILoginServer {
    @Autowired
    private lateinit var userInfoMapper: UserInfoMapper

    @Autowired
    private lateinit var stringRedisTemplate: StringRedisTemplate

    override fun getLoginToken(phone: String): ResponseLoginToken {
        val userInfo = userInfoMapper.selectOne(
                QueryWrapper<POJOUserInfo>()
                        .eq(DatabaseTables.UserInfo.FIELD_NAME_PHONE, phone)
        )
        if (userInfo == null) {
            throw NoUserException()
        } else if (stringRedisTemplate.hasKey(userInfo.id)) {
            throw OtherUserHasLoginException()
        } else {
            return ResponseLoginToken(phone)
        }
    }
}