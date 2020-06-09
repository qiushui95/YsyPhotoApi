package son.ysy.photo.throwables

class TokenExpiredException : BaseException(
        ExceptionCode.CODE_TOKEN_EXPIRED,
        ExceptionMessage.MESSAGE_TOKEN_EXPIRED
)