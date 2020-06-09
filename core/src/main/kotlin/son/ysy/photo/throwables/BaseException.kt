package son.ysy.photo.throwables

import com.google.gson.annotations.SerializedName

abstract class BaseException(
        val code: Int,
        msg: String
) : RuntimeException(msg) {
    data class ErrorResponseResult(
            @SerializedName("code")
            val code: Int,
            @SerializedName("message")
            val msg: String
    )

    val responseResult = ErrorResponseResult(code, msg)
}