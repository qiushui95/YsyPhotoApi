package son.ysy.photo.service.upload

import son.ysy.photo.model.request.RequestPreCheck
import son.ysy.photo.model.response.ResponsePreCheck

interface IUploadService {

    fun preCheck(uploadImageList: List<RequestPreCheck>): ResponsePreCheck

    fun getUploadToken(imageType:Int):
}