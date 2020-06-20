package son.ysy.photo.core.controllers

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import son.ysy.photo.model.constant.ParameterNames


@RunWith(SpringRunner::class)
@SpringBootTest
class UserInfoControllerTest : BaseControllerTest() {

    private val loginControllerTest = LoginControllerTest()

    @Before
    fun beforeLogin() {
        login()
    }


    fun insertMoreImage(){

    }

    @Test
    fun testGetUploadRecord() {
        loginControllerTest.testLogin()
        val result = mock.perform(
                MockMvcRequestBuilders.get("/user/upload/record")
                        .addCommonInfo()
                        .addLoginInfo()
                        .queryParam(ParameterNames.PARAMETER_NAME_PAGE, "12")
        ).andReturn()
        println(result.response.contentAsString)
    }
}