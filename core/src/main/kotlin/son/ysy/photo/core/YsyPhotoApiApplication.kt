package son.ysy.photo.core

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans

@SpringBootApplication
@MapperScan("son.ysy.photo.mapper")
@ComponentScans(
        ComponentScan("son.ysy.photo.property"),
        ComponentScan("son.ysy.photo.configuration"),
        ComponentScan("son.ysy.photo.service"),
        ComponentScan("son.ysy.photo.controller")
)
open class YsyPhotoApiApplication

fun main(args: Array<String>) {
    runApplication<YsyPhotoApiApplication>(*args)
}