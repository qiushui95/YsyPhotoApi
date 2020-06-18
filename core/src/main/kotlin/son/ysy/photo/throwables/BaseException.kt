package son.ysy.photo.throwables

import com.google.gson.annotations.SerializedName

abstract class BaseException(
        val code: Int,
        private val exceptionMessage: ExceptionMessage
) : RuntimeException(exceptionMessage.debug) {
    data class ErrorResponseResult(
            @SerializedName("code")
            val code: Int,
            @SerializedName("message")
            val msg: String
    )

    var isDebug: Boolean = false

    val responseResult: ErrorResponseResult
        get() = ErrorResponseResult(
                code,
                exceptionMessage.debug.takeIf {
                    isDebug == true
                } ?: exceptionMessage.release
        )
}