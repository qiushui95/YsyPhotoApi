import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Libs.SpringBoot.group) version Versions.springBoot
    id(Libs.Spring.plugin) version Versions.springPlugin
    kotlin(Libs.Kotlin.jvm) version Versions.kotlin
    kotlin(Libs.Kotlin.spring) version Versions.kotlin
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

allprojects {
    group = "son.ysy.photo.api"
    version = Versions.code

    repositories {
        RepositoryUtil.config(this)
    }
}
subprojects {

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}

