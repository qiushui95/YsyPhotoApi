package son.ysy.photo.ext

import com.google.gson.Gson
import son.ysy.photo.throwables.BaseException
import javax.servlet.http.HttpServletResponse

fun HttpServletResponse.postError(gson: Gson, exception: BaseException) {
    addHeader("Content-type", "application/json;charset=UTF-8")
    writer.apply {
        write(gson.toJson(exception.responseResult))
    }
    status = exception.code
}