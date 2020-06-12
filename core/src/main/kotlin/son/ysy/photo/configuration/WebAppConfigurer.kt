package son.ysy.photo.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import son.ysy.photo.interceptor.TokenInterceptor

@Configuration
open class WebAppConfigurer : WebMvcConfigurer {

    @Bean
    open fun getTokenInterceptor() = TokenInterceptor()

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)
        registry.addInterceptor(getTokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login/post")
    }
}