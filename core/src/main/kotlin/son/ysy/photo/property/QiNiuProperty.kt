package son.ysy.photo.property

import com.qiniu.util.Auth
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.net.URLEncoder

@Component
@ConfigurationProperties("qiniu")
class QiNiuProperty {

    lateinit var accessKey: String

    lateinit var secretKey: String

    lateinit var bucket: String

    lateinit var host: String

    lateinit var defaultAvatar: String

    private fun createAuth() = Auth.create(accessKey, secretKey)

    fun createUploadToken(): String = createAuth()
            .uploadToken(bucket, null, 10 * 60, null)

    fun encodeImageUrl(fileName: String): String {
        val encodedFileName = URLEncoder.encode(fileName, "UTF-8").replace("+", "%20")
        val publicUrl = "$host/$encodedFileName"
        val expireInSeconds = 60L * 10
        return createAuth().privateDownloadUrl(publicUrl, expireInSeconds)
    }
}