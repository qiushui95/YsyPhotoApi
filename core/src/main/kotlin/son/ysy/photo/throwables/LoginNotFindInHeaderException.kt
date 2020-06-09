package son.ysy.photo.throwables

class LoginNotFindInHeaderException : BaseException(
        ExceptionCode.CODE_TOKEN_NOT_FIND_IN_HEADER,
        ExceptionMessage.MESSAGE_TOKEN_NOT_FIND_IN_HEADER
)