package son.ysy.photo.configuration

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.throwables.BaseException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = [BaseException::class])
    fun catchBaseException(request: HttpServletRequest, response: HttpServletResponse, ex: BaseException): BaseException.ErrorResponseResult {
        ex.isDebug = request.getHeader(ParameterNames.PARAMETER_NAME_DEBUG)?.toBoolean() ?: false
        response.status = ex.code
        return ex.responseResult
    }

    @ResponseBody
    @ExceptionHandler(value = [Exception::class])
    fun catchMoreException(request: HttpServletRequest, response: HttpServletResponse, ex: Exception): BaseException.ErrorResponseResult {
        return BaseException.ErrorResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.message ?: "未知错误").apply {
            response.status = code
        }
    }
}