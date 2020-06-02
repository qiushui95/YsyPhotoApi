package son.ysy.photo.model

/**
 * 用户头像记录POJO
 */
class AvatarRecord(
        /**
         * 用户id 外键
         */
        val userId: String,
        /**
         * 图片id 外键
         */
        val imageId: String,
        /**
         * 是否为当前头像
         */
        val isCurrent: Boolean
):BasePOJO()