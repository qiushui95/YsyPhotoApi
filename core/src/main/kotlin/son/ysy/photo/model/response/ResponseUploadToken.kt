package son.ysy.photo.model.response

import com.google.gson.annotations.SerializedName

data class ResponseUploadToken(
        @SerializedName("token")
        val token: String,
        @SerializedName("prefix")
        val prefix: String
)