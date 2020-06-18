package son.ysy.photo.configuration

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.custom.NotDefineException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class GlobalExceptionHandler {
    private fun configBaseException(ex: BaseException, request: HttpServletRequest, response: HttpServletResponse) {
        ex.isDebug = request.getHeader(ParameterNames.PARAMETER_NAME_DEBUG)?.toBoolean() ?: false
        response.status = ex.code
    }

    @ResponseBody
    @ExceptionHandler(value = [BaseException::class])
    fun catchBaseException(request: HttpServletRequest, response: HttpServletResponse, ex: BaseException): BaseException.ErrorResponseResult {
        configBaseException(ex, request, response)
        return ex.responseResult
    }

    @ResponseBody
    @ExceptionHandler(value = [Exception::class])
    fun catchMoreException(request: HttpServletRequest, response: HttpServletResponse, ex: Exception): BaseException.ErrorResponseResult {
        val notDefineException = NotDefineException(ex)
        configBaseException(notDefineException, request, response)
        return notDefineException.responseResult
    }
}