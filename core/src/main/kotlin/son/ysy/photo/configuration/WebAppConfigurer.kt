package son.ysy.photo.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import son.ysy.photo.interceptor.CommonParameterInterceptor
import son.ysy.photo.interceptor.TokenInterceptor
import son.ysy.photo.interceptor.VersionCheckInterceptor

@Configuration
open class WebAppConfigurer : WebMvcConfigurer {

    @Bean
    open fun getCommonParameterInterceptor() = CommonParameterInterceptor()
    @Bean
    open fun getVersionCheckInterceptor() = VersionCheckInterceptor()

    @Bean
    open fun getTokenInterceptor() = TokenInterceptor()

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)
        registry.addInterceptor(getCommonParameterInterceptor())
                .addPathPatterns("/**")

        registry.addInterceptor(getVersionCheckInterceptor())
                .addPathPatterns("/**")

        registry.addInterceptor(getTokenInterceptor())
                .addPathPatterns("/**")
    }
}