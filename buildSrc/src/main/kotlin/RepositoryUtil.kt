import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven

object RepositoryUtil {
    fun config(handler: RepositoryHandler) {
        handler.mavenLocal()
//        handler.maven("https://maven.aliyun.com/repository/google/")
//        handler.maven("https://maven.aliyun.com/repository/jcenter/")
//        handler.maven("https://maven.aliyun.com/repository/central/")
        handler.maven("https://jitpack.io/")
        handler.jcenter()
        handler.mavenCentral()
        handler.maven("https://maven.aliyun.com/nexus/content/groups/public/")
    }
}