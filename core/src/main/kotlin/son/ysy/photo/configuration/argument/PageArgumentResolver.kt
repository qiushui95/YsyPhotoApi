package son.ysy.photo.configuration.argument

import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.ModelAndViewContainer
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.model.request.RequestPageInfo
import son.ysy.photo.throwables.interceptor.ParameterMissException

@Configuration
open class PageArgumentResolver : BaseArgumentResolver<RequestPageInfo>(RequestPageInfo::class) {


    override fun createArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer?, webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?): RequestPageInfo {
        val page = webRequest.getParameter(ParameterNames.PARAMETER_NAME_PAGE)
                ?.toLongOrNull()
                ?: throw ParameterMissException(ParameterNames.PARAMETER_NAME_PAGE)
        val pageSize = (webRequest.getParameter(ParameterNames.PARAMETER_NAME_PAGE_SIZE)
                ?.toLongOrNull()
                ?: 10)
        return RequestPageInfo(page, pageSize)
    }
}