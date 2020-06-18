package son.ysy.photo.throwables

sealed class ExceptionMessage(val debug: String, val release: String) {
    private companion object {
        const val MESSAGE_NOT_LOGIN = "暂未登录,请先登录"
    }

    constructor(message: String) : this(message, message)

    //region 未定义异常
    class NotDefineError(message: String) : ExceptionMessage(message, "服务器异常,请稍后重试")
    //endregion

    class CustomError(debug: String, release: String) : ExceptionMessage(debug, release)

    //region 图片类型未定义
    object ImageTypeNotDefine : ExceptionMessage("未知图片类型")
    //endregion

    //region header无登录信息
    object TokenNotFindInHeader : ExceptionMessage("header登录参数缺失", MESSAGE_NOT_LOGIN)
    //endregion


    //region token过期
    object TokenExpired : ExceptionMessage("登录信息过期,请重新登录")
    //endregion


    //region 用户未注册
    object UserNotRegister : ExceptionMessage("用户未注册,请联系管理员")
    //endregion


    //region 手机号已登录在其他设备
    object LoginOnOtherDevice : ExceptionMessage("该手机号已登录在其他设备,请联系管理员")
    //endregion
}