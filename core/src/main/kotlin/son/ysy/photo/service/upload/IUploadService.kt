package son.ysy.photo.service.upload

import son.ysy.photo.model.request.RequestUploadPreCheck
import son.ysy.photo.model.response.ResponsePreCheck
import son.ysy.photo.model.response.ResponseUploadToken

interface IUploadService {

    fun preCheck(uploadImageList: List<RequestUploadPreCheck>): ResponsePreCheck

    fun getUploadToken(type: Int): ResponseUploadToken
}