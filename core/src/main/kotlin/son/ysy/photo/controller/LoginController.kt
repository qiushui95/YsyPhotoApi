package son.ysy.photo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import son.ysy.photo.annotations.LoginCheck
import son.ysy.photo.service.login.ILoginServer

@RestController
@RequestMapping("login")
class LoginController {

    @Autowired
    private lateinit var loginserver: ILoginServer

    @PostMapping
    @LoginCheck(needCheck = false)
    fun postLogin(@RequestParam("phone") phone: String) = loginserver.getLoginToken(phone)

    @GetMapping
    fun checkLogin() = true
}