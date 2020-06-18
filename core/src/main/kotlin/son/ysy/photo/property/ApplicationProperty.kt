package son.ysy.photo.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties("application")
class ApplicationProperty {
    var minVersionCode: Int = 0
}