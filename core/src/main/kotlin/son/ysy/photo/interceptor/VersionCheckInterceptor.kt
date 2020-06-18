package son.ysy.photo.interceptor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.annotations.MinAppVersionCode
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.property.ApplicationProperty
import son.ysy.photo.throwables.interceptor.ParameterMissException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class VersionCheckInterceptor : HandlerInterceptorAdapter() {


    @Autowired
    private lateinit var applicationProperty: ApplicationProperty

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val versionCode = request.getHeader(ParameterNames.PARAMETER_NAME_VERSION_CODE)!!.toInt()

        val minVersionCode = ((handler as? HandlerMethod)
                ?.getMethodAnnotation(MinAppVersionCode::class.java)
                ?.versionCode
                ?: applicationProperty.minVersionCode)
        when {
            versionCode < minVersionCode -> {
                throw ParameterMissException(ParameterNames.PARAMETER_NAME_VERSION_CODE)
            }
        }
        return super.preHandle(request, response, handler)
    }
}