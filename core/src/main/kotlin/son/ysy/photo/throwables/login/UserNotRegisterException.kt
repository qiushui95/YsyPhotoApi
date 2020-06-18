package son.ysy.photo.throwables.login

import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.ExceptionCode
import son.ysy.photo.throwables.ExceptionMessage

class UserNotRegisterException : BaseException(
        ExceptionCode.CODE_USER_NOT_REGISTER,
        ExceptionMessage.UserNotRegister
)