plugins {
    kotlin(Libs.Kotlin.jvm)
    kotlin(Libs.Kotlin.kapt)
    id(Libs.SpringBoot.group)
    id(Libs.Spring.plugin)
}

dependencies {
    implementation(kotlin(Libs.Kotlin.stdlib))
    implementation(kotlin(Libs.Kotlin.reflect))

    implementation(Libs.SpringBoot.starterWeb) {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-json")
    }
    testImplementation(Libs.SpringBoot.starterTest)
    kapt(Libs.SpringBoot.configuration)

    implementation(Libs.MybatisPlus.springBoot)

    implementation(Libs.Mysql.connector)

    implementation(Libs.QiNiu.core)

    implementation(Libs.Gson.core)
}
