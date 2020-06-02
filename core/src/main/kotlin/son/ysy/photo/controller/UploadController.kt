package son.ysy.photo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import son.ysy.photo.model.request.RequestPreCheck
import son.ysy.photo.service.upload.IUploadService

@RestController
@RequestMapping("upload")
class UploadController {

    @Autowired
    private lateinit var uploadService: IUploadService

    @PostMapping("preCheck")
    fun preCheck(@RequestBody uploadImageList: List<RequestPreCheck>) = uploadService.preCheck(uploadImageList)
}