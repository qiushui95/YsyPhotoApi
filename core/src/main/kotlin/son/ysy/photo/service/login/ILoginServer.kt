package son.ysy.photo.service.login

import son.ysy.photo.model.response.ResponseLoginResult

interface ILoginServer {

    fun getLoginToken(phone: String): ResponseLoginResult
}