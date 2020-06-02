package son.ysy.photo.model.pojo

import son.ysy.photo.model.pojo.BasePOJO
import java.util.*

/**
 * 图像信息POJO
 */
class POJOImageInfo(
        /**
         * 图片链接
         */
        val imageUrl: String,
        /**
         * 图片宽度
         */
        val width: Int,
        /**
         * 图片高度
         */
        val height: Int,
        /**
         * 是否删除
         */
        val hasDelete: Boolean,
        /**
         * 图片类型,详见@Link ImageType
         */
        val imageType: Int,
        /**
         * 拍摄时间
         */
        val takeTime: Date,
        /**
         * 图片唯一md5
         */
        val md5: String
) : BasePOJO() {
    companion object {
        const val COLUMN_NAME_ID = BasePOJO.COLUMN_NAME_ID
        const val COLUMN_NAME_IMAGE_URL = "imageUrl"
        const val COLUMN_NAME_WIDTH = "width"
        const val COLUMN_NAME_HEIGHT = "height"
        const val COLUMN_NAME_HAS_DELETE = "hasDelete"
        const val COLUMN_NAME_IMAGE_TYPE = "imageType"
        const val COLUMN_NAME_TAKE_TIME = "takeTime"
        const val COLUMN_NAME_MD5 = "md5"
    }
}