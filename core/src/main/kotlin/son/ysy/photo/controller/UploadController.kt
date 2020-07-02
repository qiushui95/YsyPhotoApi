package son.ysy.photo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.service.upload.IUploadService

@RestController
@RequestMapping("upload")
class UploadController {

    @Autowired
    private lateinit var uploadService: IUploadService

    @GetMapping("preCheck")
    fun preCheck(@RequestParam(ParameterNames.PARAMETER_NAME_IMAGE_MD5) imageMd5: String) = uploadService.preCheck(imageMd5)

    @GetMapping("token")
    fun getUploadToken(@RequestParam(name = ParameterNames.PARAMETER_NAME_IMAGE_TYPE) type: Int) = uploadService.getUploadToken(type)
}