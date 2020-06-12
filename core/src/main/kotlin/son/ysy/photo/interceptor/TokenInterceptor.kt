package son.ysy.photo.interceptor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.throwables.TokenExpiredException
import son.ysy.photo.throwables.LoginNotFindInHeaderException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenInterceptor : HandlerInterceptorAdapter() {

    companion object {
        private const val HEADER_KEY_TOKEN = "token"
        private const val HEADER_KEY_USER_ID = "userId"
    }

    @Autowired
    lateinit var redisTemplate: StringRedisTemplate

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = request.getHeader(HEADER_KEY_TOKEN)
        val userId = request.getHeader(HEADER_KEY_USER_ID)
        when {
            token.isNullOrBlank() || userId.isNullOrBlank() -> {
                throw  LoginNotFindInHeaderException()
            }
            !redisTemplate.hasKey(userId) || redisTemplate.opsForValue().get(userId) != token -> {
                throw  TokenExpiredException()
            }
        }
        return super.preHandle(request, response, handler)
    }
}