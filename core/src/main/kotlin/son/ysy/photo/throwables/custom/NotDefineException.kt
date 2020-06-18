package son.ysy.photo.throwables.custom

import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.ExceptionCode
import son.ysy.photo.throwables.ExceptionMessage

class NotDefineException(throwable: Throwable) : BaseException(
        ExceptionCode.CODE_NOT_DEFINE_ERROR,
        ExceptionMessage.NotDefineError(throwable.message ?: "no message")
)