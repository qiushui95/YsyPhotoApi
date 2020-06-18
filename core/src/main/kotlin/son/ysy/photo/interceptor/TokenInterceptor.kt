package son.ysy.photo.interceptor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.annotations.LoginCheck
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.throwables.login.LoginNotFindInHeaderException
import son.ysy.photo.throwables.login.TokenExpiredException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenInterceptor : HandlerInterceptorAdapter() {

    @Autowired
    lateinit var redisTemplate: StringRedisTemplate


    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val needCheckLogin = ((handler as? HandlerMethod)
                ?.getMethodAnnotation(LoginCheck::class.java)
                ?.needCheck
                ?: true)
        if (needCheckLogin) {
            val token = request.getHeader(ParameterNames.PARAMETER_NAME_TOKEN)
            val userId = request.getHeader(ParameterNames.PARAMETER_NAME_USER_ID)

            when {
                token.isNullOrBlank() || userId.isNullOrBlank() -> {
                    throw LoginNotFindInHeaderException()
                }
                !redisTemplate.hasKey(userId) || redisTemplate.opsForValue().get(userId) != token -> {
                    throw TokenExpiredException()
                }
            }
        }
        return super.preHandle(request, response, handler)
    }
}