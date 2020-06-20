package son.ysy.photo.configuration.argument

import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.ModelAndViewContainer
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.model.request.RequestPageInfo
import son.ysy.photo.model.request.RequestUserId
import son.ysy.photo.throwables.interceptor.ParameterMissException

@Configuration
open class UserIdArgumentResolver : BaseArgumentResolver<RequestUserId>(RequestUserId::class) {

    override fun createArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer?, webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?): RequestUserId {
        val userId = webRequest.getHeader(ParameterNames.PARAMETER_NAME_USER_ID)
                ?: throw ParameterMissException(ParameterNames.PARAMETER_NAME_USER_ID)
        return RequestUserId(userId)
    }
}