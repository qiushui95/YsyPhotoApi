package son.ysy.photo.model

/**
 * 图片类型限制注解
 */
annotation class ImageType {
    companion object {
        /**
         * 普通图片
         */
        const val NORMAL = 1

        /**
         * 头像图片
         */
        const val AVATAR = 2
    }
}