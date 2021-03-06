package son.ysy.photo.service.login

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import son.ysy.photo.mapper.DatabaseTables
import son.ysy.photo.mapper.UserInfoMapper
import son.ysy.photo.model.tables.POJOUserInfo
import son.ysy.photo.model.response.ResponseLoginResult
import son.ysy.photo.throwables.login.UserNotRegisterException
import son.ysy.photo.throwables.login.OtherUserHasLoginException

@Service
class LoginServerImpl : ILoginServer {
    @Autowired
    private lateinit var userInfoMapper: UserInfoMapper

    @Autowired
    private lateinit var stringRedisTemplate: StringRedisTemplate

    override fun getLoginToken(phone: String): ResponseLoginResult {
        val userInfo = userInfoMapper.selectOne(
                QueryWrapper<POJOUserInfo>()
                        .eq(DatabaseTables.UserInfo.FIELD_NAME_PHONE, phone)
        )
        when {
            userInfo == null -> {
                throw UserNotRegisterException()
            }
            stringRedisTemplate.hasKey(userInfo.id) -> {
                throw OtherUserHasLoginException()
            }
            else -> {
                val token = phone
                stringRedisTemplate.opsForValue()
                        .set(userInfo.id, token)
                return ResponseLoginResult(userInfo.id, token)
            }
        }
    }
}