package son.ysy.photo.throwables.upload

import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.ExceptionCode
import son.ysy.photo.throwables.ExceptionMessage

class ImageTypeNotDefineException : BaseException(
        ExceptionCode.CODE_IMAGE_TYPE_NOT_DEFINE,
        ExceptionMessage.ImageTypeNotDefine
)