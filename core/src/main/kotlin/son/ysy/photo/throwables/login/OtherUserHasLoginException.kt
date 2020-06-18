package son.ysy.photo.throwables.login

import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.ExceptionCode
import son.ysy.photo.throwables.ExceptionMessage

class OtherUserHasLoginException : BaseException(
        ExceptionCode.CODE_LOGIN_ON_OTHER_DEVICE,
        ExceptionMessage.LoginOnOtherDevice
)