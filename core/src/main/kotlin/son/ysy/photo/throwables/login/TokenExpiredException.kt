package son.ysy.photo.throwables.login

import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.ExceptionCode
import son.ysy.photo.throwables.ExceptionMessage

class TokenExpiredException : BaseException(
        ExceptionCode.CODE_TOKEN_EXPIRED,
        ExceptionMessage.TokenExpired
)