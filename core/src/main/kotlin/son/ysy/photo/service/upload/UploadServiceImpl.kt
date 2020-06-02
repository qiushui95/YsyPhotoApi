package son.ysy.photo.service.upload

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import son.ysy.photo.mapper.ImageInfoMapper
import son.ysy.photo.model.pojo.POJOImageInfo
import son.ysy.photo.model.request.RequestPreCheck
import son.ysy.photo.model.response.ResponsePreCheck

@Service
class UploadServiceImpl : IUploadService {

    @Autowired
    private lateinit var imageInfoMapper: ImageInfoMapper

    override fun preCheck(uploadImageList: List<RequestPreCheck>): ResponsePreCheck {
        val list = imageInfoMapper.selectList(QueryWrapper<POJOImageInfo>().`in`(POJOImageInfo.COLUMN_NAME_MD5, uploadImageList.map { it.md5 }))
        return ResponsePreCheck(uploadImageList, uploadImageList)
    }
}