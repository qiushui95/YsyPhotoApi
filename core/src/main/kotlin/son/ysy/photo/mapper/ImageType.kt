package son.ysy.photo.mapper

import son.ysy.photo.throwables.ImageTypeNotDefineException

/**
 * 图片类型
 */
sealed class ImageType(val type: Int, val prefix: String) {

    /**
     * 照片
     */
    object Photo : ImageType(1, "photo/")

    /**
     * 头像
     */
    object Avatar : ImageType(2, "avatar/")


    companion object {
        private val imageTypeArray = arrayOf(Photo, Avatar)

        /**
         * 通过传入type获取ImageType
         */
        @Throws(ImageTypeNotDefineException::class)
        fun getImageTypeByType(type: Int) = imageTypeArray.firstOrNull {
            it.type == type
        } ?: throw ImageTypeNotDefineException()
    }
}