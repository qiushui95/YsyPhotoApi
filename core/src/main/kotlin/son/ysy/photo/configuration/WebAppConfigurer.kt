package son.ysy.photo.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import son.ysy.photo.configuration.argument.LoginResultArgumentResolver
import son.ysy.photo.configuration.argument.PageArgumentResolver
import son.ysy.photo.configuration.argument.UserIdArgumentResolver
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

    @Bean
    open fun getPageArgumentResolver() = PageArgumentResolver()

    @Bean
    open fun getUserIdArgumentResolver() = UserIdArgumentResolver()
    @Bean
    open fun getLoginResultArgumentResolver() = LoginResultArgumentResolver()

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)
        registry.addInterceptor(getCommonParameterInterceptor())
                .addPathPatterns("/**")

        registry.addInterceptor(getVersionCheckInterceptor())
                .addPathPatterns("/**")

        registry.addInterceptor(getTokenInterceptor())
                .addPathPatterns("/**")
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        super.addArgumentResolvers(resolvers)
        resolvers.apply {
            add(getPageArgumentResolver())
            add(getUserIdArgumentResolver())
            add(getLoginResultArgumentResolver())
        }
    }
}