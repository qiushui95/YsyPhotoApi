package son.ysy.photo.model.pojo

import son.ysy.photo.model.pojo.BasePOJO

/**
 * 用户头像记录POJO
 */
class POJOAvatarRecord(
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
): BasePOJO()