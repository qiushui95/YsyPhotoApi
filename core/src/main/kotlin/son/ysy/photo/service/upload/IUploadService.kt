package son.ysy.photo.service.upload

import son.ysy.photo.model.response.ResponseUploadToken

interface IUploadService {

    fun preCheck(imageMd5: String): Boolean

    fun getUploadToken(type: Int): ResponseUploadToken
}