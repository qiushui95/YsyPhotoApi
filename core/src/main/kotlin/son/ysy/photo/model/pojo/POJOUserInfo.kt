package son.ysy.photo.model.pojo

import son.ysy.photo.model.pojo.BasePOJO

/**
 * 用户信息POJO
 */
data class POJOUserInfo(
        /**
         * 用户手机号
         */
        val phone: String,
        /**
         * 关系id外键
         */
        val relationshipId: String
) : BasePOJO()