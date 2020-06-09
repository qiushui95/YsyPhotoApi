package son.ysy.photo.throwables

object ExceptionCode {
    /**
     * 错误码-图片类型未定义
     */
    const val CODE_IMAGE_TYPE_NOT_DEFINE = 600

    /**
     * 错误码-header无登录信息
     */
    const val CODE_TOKEN_NOT_FIND_IN_HEADER = 700

    /**
     * 错误码-登录过期
     */
    const val CODE_TOKEN_EXPIRED = 701
    /**
     * 错误码-用户未注册
     */
    const val CODE_NO_USER = 710
    /**
     * 错误码-已登录在其他设备
     */
    const val CODE_LOGIN_ON_OTHER_DEVICE = 711
}