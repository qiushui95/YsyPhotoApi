package son.ysy.photo.model.vo

import java.util.*

data class UserUploadRecordVo(
        val id: String,
        val imageUrl: String,
        val width: Int,
        val height: Int,
        val takeTime: Date,
        val uploadTime: Date,
        val relationship: String?
)