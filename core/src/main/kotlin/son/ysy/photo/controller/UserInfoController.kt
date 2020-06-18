package son.ysy.photo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import son.ysy.photo.interceptor.TokenInterceptor
import son.ysy.photo.model.constant.ParameterNames
import son.ysy.photo.service.user.IUserInfoService

@RestController
@RequestMapping("user")
class UserInfoController {
    @Autowired
    private lateinit var userInfoService: IUserInfoService

    @GetMapping
    fun getUserInfo(@RequestHeader(ParameterNames.PARAMETER_NAME_USER_ID) userId: String) = userInfoService.getUserInfo(userId)
}