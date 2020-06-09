package son.ysy.photo.throwables

class OtherUserHasLoginException : BaseException(
        ExceptionCode.CODE_LOGIN_ON_OTHER_DEVICE,
        ExceptionMessage.MESSAGE_LOGIN_ON_OTHER_DEVICE
)