package son.ysy.photo.service.login

import son.ysy.photo.model.response.ResponseLoginToken

interface ILoginServer {

    fun getLoginToken(phone: String): ResponseLoginToken
}