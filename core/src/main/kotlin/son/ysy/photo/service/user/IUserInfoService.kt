package son.ysy.photo.service.user

import son.ysy.photo.model.response.ResponseUserInfo

interface IUserInfoService {

    fun getUserInfo(userId: String): ResponseUserInfo
}