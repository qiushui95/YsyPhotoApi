package son.ysy.photo.throwables

object ExceptionMessage {
    /**
     * 错误信息-图片类型未定义
     */
    const val MESSAGE_IMAGE_TYPE_NOT_DEFINE = "未知图片类型"

    /**
     * 错误信息-header无登录信息
     */
    const val MESSAGE_TOKEN_NOT_FIND_IN_HEADER = "header中未找到登录参数"

    /**
     * 错误信息-header无登录信息
     */
    const val MESSAGE_TOKEN_EXPIRED = "登录信息过期"

    /**
     * 错误信息-用户未注册
     */
    const val MESSAGE_NO_USER = "用户未注册,请联系管理员"

    /**
     * 错误信息-已登录在其他设备
     */
    const val MESSAGE_LOGIN_ON_OTHER_DEVICE = "该手机号已登录在其他设备,请联系管理员"
}