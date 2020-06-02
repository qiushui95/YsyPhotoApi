package son.ysy.photo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import son.ysy.photo.app.StringUtil

@RestController
@RequestMapping("test")
class TestController {

    @GetMapping("test1")
    fun test(value: String) = StringUtil.dealString(value)
}