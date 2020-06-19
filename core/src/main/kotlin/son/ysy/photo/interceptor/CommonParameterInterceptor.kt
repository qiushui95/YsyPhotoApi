package son.ysy.photo.interceptor

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.throwables.interceptor.ParameterMissException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CommonParameterInterceptor : HandlerInterceptorAdapter() {


    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val debug = request.getHeader(ParameterNames.PARAMETER_NAME_DEBUG)?.toBoolean()
        val versionCode = request.getHeader(ParameterNames.PARAMETER_NAME_VERSION_CODE)?.toIntOrNull()

//        Thread.sleep(10000)
        when {
            debug == null -> {
                throw ParameterMissException(ParameterNames.PARAMETER_NAME_DEBUG)
            }
            versionCode == null -> {
                throw ParameterMissException(ParameterNames.PARAMETER_NAME_VERSION_CODE)
            }
        }
        return super.preHandle(request, response, handler)
    }
}