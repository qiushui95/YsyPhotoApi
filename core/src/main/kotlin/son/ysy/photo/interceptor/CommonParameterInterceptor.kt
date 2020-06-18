package son.ysy.photo.interceptor

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.ext.postError
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.throwables.interceptor.ParameterMissException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CommonParameterInterceptor : HandlerInterceptorAdapter() {

    @Autowired
    lateinit var gson: Gson


    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val debug = request.getHeader(ParameterNames.PARAMETER_NAME_DEBUG)?.toBoolean()
        val versionCode = request.getHeader(ParameterNames.PARAMETER_NAME_VERSION_CODE)?.toIntOrNull()

//        Thread.sleep(5000)
        when {
            debug == null -> {
                response.postError(gson, ParameterMissException( ParameterNames.PARAMETER_NAME_DEBUG))
                return false
            }
            versionCode == null -> {
                response.postError(gson, ParameterMissException(ParameterNames.PARAMETER_NAME_VERSION_CODE))
                return false
            }
        }
        return super.preHandle(request, response, handler)
    }
}