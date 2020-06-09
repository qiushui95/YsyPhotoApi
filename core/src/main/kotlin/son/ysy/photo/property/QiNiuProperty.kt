package son.ysy.photo.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("qiniu")
class QiNiuProperty {

    lateinit var accessKey: String

    lateinit var secretKey: String

    lateinit var bucket: String

    override fun toString(): String {
        return "QiNiuProperty(accessKey='$accessKey', secretKey='$secretKey', bucket='$bucket')"
    }
}