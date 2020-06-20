package son.ysy.photo.core.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import son.ysy.photo.model.constant.ParameterNames

abstract class BaseControllerTest {

    @Autowired
    private lateinit var context: WebApplicationContext

    protected val mock by lazy {
        MockMvcBuilders.webAppContextSetup(context)
                .build()
    }

    protected fun MockHttpServletRequestBuilder.addCommonInfo(

    ) = header(ParameterNames.PARAMETER_NAME_DEBUG, true)
            .header(ParameterNames.PARAMETER_NAME_VERSION_CODE, 1)

    protected fun MockHttpServletRequestBuilder.addLoginInfo(

    ) = header(ParameterNames.PARAMETER_NAME_USER_ID, "d6616b21-5360-4fb3-b4a4-49d5ef386568")
            .header(ParameterNames.PARAMETER_NAME_TOKEN, "13540817567")

    protected fun login() {
        val contentAsString: String? = mock.perform(
                MockMvcRequestBuilders.get("/login").addCommonInfo()
                        .addLoginInfo()
        ).andReturn().response.contentAsString
        if (contentAsString?.toBoolean() != true) {
            mock.perform(
                    MockMvcRequestBuilders.post("/login").addCommonInfo()
                            .queryParam("phone", "13540817567")
            ).andReturn().response.contentAsString
        }
    }
}