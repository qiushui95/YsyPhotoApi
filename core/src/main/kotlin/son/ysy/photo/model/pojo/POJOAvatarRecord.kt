package son.ysy.photo.model.pojo

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import son.ysy.photo.mapper.DatabaseTables

/**
 * 用户头像记录POJO
 */
@TableName(DatabaseTables.AvatarRecord.TABLE_NAME)
class POJOAvatarRecord(
        /**
         * 用户id 外键
         */
        @TableField(DatabaseTables.AvatarRecord.FIELD_NAME_USER_ID)
        val userId: String,
        /**
         * 图片id 外键
         */
        @TableField(DatabaseTables.AvatarRecord.FIELD_NAME_IMAGE_ID)
        val imageId: String,
        /**
         * 是否为当前头像
         */
        @TableField(DatabaseTables.AvatarRecord.FIELD_NAME_IS_CURRENT)
        val isCurrent: Boolean
) : BasePOJO()