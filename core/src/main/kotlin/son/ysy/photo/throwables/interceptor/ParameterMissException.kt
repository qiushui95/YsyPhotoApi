package son.ysy.photo.throwables.interceptor

import son.ysy.photo.throwables.BaseException
import son.ysy.photo.throwables.ExceptionCode
import son.ysy.photo.throwables.ExceptionMessage

class ParameterMissException( parameterName: String) : BaseException(
        ExceptionCode.CODE_PARAMETER_MISS,
        ExceptionMessage.CustomError("${parameterName}参数缺失", "参数缺失")
)