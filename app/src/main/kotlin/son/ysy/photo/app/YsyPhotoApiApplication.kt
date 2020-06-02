package son.ysy.photo.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class YsyPhotoApiApplication

fun main(args: Array<String>) {
    runApplication<YsyPhotoApiApplication>(*args)
}
