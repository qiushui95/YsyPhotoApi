package son.ysy.photo.throwables

class NoUserException : BaseException(
        ExceptionCode.CODE_NO_USER,
        ExceptionMessage.MESSAGE_NO_USER
)