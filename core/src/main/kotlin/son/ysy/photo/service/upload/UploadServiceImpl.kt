package son.ysy.photo.service.upload

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import son.ysy.photo.mapper.DatabaseTables
import son.ysy.photo.mapper.ImageInfoMapper
import son.ysy.photo.mapper.ImageType
import son.ysy.photo.model.response.ResponseUploadToken
import son.ysy.photo.model.tables.POJOImageInfo
import son.ysy.photo.property.QiNiuProperty
import javax.annotation.Resource

@Service
class UploadServiceImpl : IUploadService {

    @Resource
    private lateinit var imageInfoMapper: ImageInfoMapper

    @Autowired
    private lateinit var qiNiuProperty: QiNiuProperty

    override fun preCheck(imageMd5: String): Boolean {

        return imageInfoMapper.selectOne(QueryWrapper<POJOImageInfo>().eq(DatabaseTables.ImageInfo.FIELD_NAME_MD5, imageMd5)) == null
    }

    override fun getUploadToken(type: Int): ResponseUploadToken {
        val imageType = ImageType.getImageTypeByType(type)
        val token = qiNiuProperty.createUploadToken()
        return ResponseUploadToken(token, imageType.prefix)
    }
}