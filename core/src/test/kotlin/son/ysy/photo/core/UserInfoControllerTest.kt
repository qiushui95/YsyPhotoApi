package son.ysy.photo.core

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
class UserInfoControllerTest {
    @Autowired
    private lateinit var context: WebApplicationContext

    private val mock by lazy {
        MockMvcBuilders.webAppContextSetup(context)
                .build()
    }

    @Test
    fun testGetUploadRecord() {
        val result = mock.perform(
                MockMvcRequestBuilders.get("/user/upload/record")
                        .header(ParameterNames.PARAMETER_NAME_USER_ID, "d6616b21-5360-4fb3-b4a4-49d5ef386568")
                        .header(ParameterNames.PARAMETER_NAME_TOKEN, "13540817567")
                        .header(ParameterNames.PARAMETER_NAME_DEBUG, true)
                        .header(ParameterNames.PARAMETER_NAME_VERSION_CODE, 1)
        ).andReturn()
        println(result.response.contentAsString)
    }
}