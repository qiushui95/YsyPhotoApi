package son.ysy.photo.service.upload

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.qiniu.util.Auth
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import son.ysy.photo.ext.subListNotIn
import son.ysy.photo.mapper.DatabaseTables
import son.ysy.photo.mapper.ImageInfoMapper
import son.ysy.photo.mapper.ImageType
import son.ysy.photo.model.pojo.POJOImageInfo
import son.ysy.photo.model.request.RequestPreCheck
import son.ysy.photo.model.response.ResponsePreCheck
import son.ysy.photo.model.response.ResponseUploadToken
import son.ysy.photo.property.QiNiuProperty
import son.ysy.photo.throwables.ImageTypeNotDefineException
import java.util.*

@Service
class UploadServiceImpl : IUploadService {

    @Autowired
    private lateinit var imageInfoMapper: ImageInfoMapper

    @Autowired
    private lateinit var qiNiuProperty: QiNiuProperty

    override fun preCheck(uploadImageList: List<RequestPreCheck>): ResponsePreCheck {
        val list = imageInfoMapper.selectList(
                QueryWrapper<POJOImageInfo>()
                        .`in`(DatabaseTables.ImageInfo.FIELD_NAME_MD5, uploadImageList.map { it.md5.toLowerCase(Locale.ENGLISH) })
        ).map {
            it.md5
        }
        val canUploadList = uploadImageList.filterNot {
            it.md5 in list
        }
        val containedList = uploadImageList.subListNotIn(canUploadList)
        return ResponsePreCheck(canUploadList, containedList)
    }

    override fun getUploadToken( type: Int): ResponseUploadToken {
        val imageType = ImageType.getImageTypeByType(type)
        val token = Auth.create(qiNiuProperty.accessKey, qiNiuProperty.secretKey)
                .run {
                    uploadToken(qiNiuProperty.bucket, null, 10 * 60, null)
                }
        return ResponseUploadToken(token, imageType.prefix)
    }
}