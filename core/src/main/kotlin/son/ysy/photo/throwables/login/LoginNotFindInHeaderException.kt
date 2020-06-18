package son.ysy.photo.throwables.login

import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.ExceptionCode
import son.ysy.photo.throwables.ExceptionMessage

class LoginNotFindInHeaderException : BaseException(
        ExceptionCode.CODE_TOKEN_NOT_FIND_IN_HEADER,
        ExceptionMessage.TokenNotFindInHeader
)