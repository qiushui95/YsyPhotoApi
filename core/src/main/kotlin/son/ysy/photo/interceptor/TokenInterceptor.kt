package son.ysy.photo.interceptor

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.ext.postError
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.throwables.login.TokenExpiredException
import son.ysy.photo.throwables.login.LoginNotFindInHeaderException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenInterceptor : HandlerInterceptorAdapter() {

    @Autowired
    lateinit var redisTemplate: StringRedisTemplate


    @Autowired
    lateinit var gson: Gson


    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = request.getHeader(ParameterNames.PARAMETER_NAME_TOKEN)
        val userId = request.getHeader(ParameterNames.PARAMETER_NAME_USER_ID)

        when {
            token.isNullOrBlank() || userId.isNullOrBlank() -> {
                response.postError(gson, LoginNotFindInHeaderException())
                return false
            }
            !redisTemplate.hasKey(userId) || redisTemplate.opsForValue().get(userId) != token -> {
                response.postError(gson, TokenExpiredException())
                return false
            }
        }
        return super.preHandle(request, response, handler)
    }
}