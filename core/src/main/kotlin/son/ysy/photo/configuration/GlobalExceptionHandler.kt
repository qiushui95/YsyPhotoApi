package son.ysy.photo.configuration

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import son.ysy.photo.throwables.BaseException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [BaseException::class])
    @ResponseBody
    fun catchBaseException(request: HttpServletRequest, response: HttpServletResponse, ex: BaseException): BaseException.ErrorResponseResult {
        response.status = ex.code
        return ex.responseResult
    }
}