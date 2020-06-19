package son.ysy.photo.model.tables

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import son.ysy.photo.mapper.DatabaseTables
import java.util.*

/**
 * 图像信息POJO
 */
@TableName(DatabaseTables.ImageInfo.TABLE_NAME)
data class POJOImageInfo(
        /**
         * 图片链接
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_IMAGE_URL)
        val imageUrl: String,
        /**
         * 图片宽度
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_WIDTH)
        val width: Int,
        /**
         * 图片高度
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_HEIGHT)
        val height: Int,
        /**
         * 是否删除
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_HAS_DELETE)
        val hasDelete: Boolean,
        /**
         * 图片类型,详见@Link ImageType
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_IMAGE_TYPE)
        val imageType: Int,
        /**
         * 拍摄时间
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_TAKE_TIME)
        val takeTime: Date,
        /**
         * 图片唯一md5
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_MD5)
        val md5: String,
        /**
         * 上传者id
         */
        @TableField(DatabaseTables.ImageInfo.FIELD_NAME_USER_ID)
        val userId: String
) : BasePOJO()