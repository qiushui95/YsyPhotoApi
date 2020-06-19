package son.ysy.photo.configuration

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import son.ysy.photo.json.DateJsonAdapter
import son.ysy.photo.json.PageJsonAdapter
import java.util.*

@Configuration
open class GsonConfiguration {
    @Bean
    open fun gson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(Page::class.java, PageJsonAdapter())
                .registerTypeAdapter(Date::class.java, DateJsonAdapter())
                .create()
    }
}