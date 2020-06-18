package son.ysy.photo.model.pojo

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import son.ysy.photo.mapper.DatabaseTables

/**
 * 用户信息POJO
 */
@TableName(DatabaseTables.UserInfo.TABLE_NAME)
data class POJOUserInfo(
        /**
         * 用户手机号
         */
        @TableField(DatabaseTables.UserInfo.FIELD_NAME_PHONE)
        val phone: String,
        /**
         * 用户手机号
         */
        @TableField(DatabaseTables.UserInfo.FIELD_NAME_AVATAR_ID)
        val avatarId: String?,
        /**
         * 关系id外键
         */
        @TableField(DatabaseTables.UserInfo.FIELD_NAME_RELATIONSHIP_ID)
        val relationshipId: String?
) : BasePOJO()