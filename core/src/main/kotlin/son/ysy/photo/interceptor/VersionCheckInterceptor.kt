package son.ysy.photo.interceptor

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.ext.postError
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.property.ApplicationProperty
import son.ysy.photo.throwables.interceptor.ParameterMissException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class VersionCheckInterceptor : HandlerInterceptorAdapter() {

    @Autowired
    private lateinit var gson: Gson

    @Autowired
    private lateinit var applicationProperty: ApplicationProperty

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val versionCode = request.getHeader(ParameterNames.PARAMETER_NAME_VERSION_CODE)!!.toInt()

        when {
            versionCode < applicationProperty.versionCode -> {
                response.postError(gson, ParameterMissException(ParameterNames.PARAMETER_NAME_VERSION_CODE))
                return false
            }
        }
        return super.preHandle(request, response, handler)
    }
}