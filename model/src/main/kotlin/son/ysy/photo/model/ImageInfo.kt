package son.ysy.photo.model

import java.util.*

/**
 * 图像信息POJO
 */
class ImageInfo(
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
) : BasePOJO()