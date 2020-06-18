package son.ysy.photo.throwables

/**
 * 错误码
 */
object ExceptionCode {

    //region 未定义异常
    const val CODE_NOT_DEFINE_ERROR = 999
    //endregion

    //region 参数缺失
    const val CODE_PARAMETER_MISS = 998
    //endregion

    //region 图片类型未定义
    const val CODE_IMAGE_TYPE_NOT_DEFINE = 600
    //endregion

    //region header无登录信息
    const val CODE_TOKEN_NOT_FIND_IN_HEADER = 700
    //endregion

    //region 登录信息过期
    const val CODE_TOKEN_EXPIRED = 701
    //endregion

    //region 用户未注册
    const val CODE_USER_NOT_REGISTER = 710
    //endregion

    //region 手机号已登录在其他设备
    const val CODE_LOGIN_ON_OTHER_DEVICE = 711
    //endregion
}