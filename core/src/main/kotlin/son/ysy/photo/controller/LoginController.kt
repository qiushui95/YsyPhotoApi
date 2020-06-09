package son.ysy.photo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import son.ysy.photo.service.login.ILoginServer

@RestController
@RequestMapping("login")
class LoginController {

    @Autowired
    private lateinit var loginserver: ILoginServer

    @PostMapping
    fun postLogin(@RequestParam("phone") phone: String) = loginserver.getLoginToken(phone)
}