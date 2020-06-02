plugins {
    kotlin(Libs.Kotlin.jvm)
    id(Libs.SpringBoot.plugin)
    id(Libs.Spring.plugin)
}

dependencies {
    implementation(project(Libs.Module.controller))

    implementation(kotlin(Libs.Kotlin.stdlib))
    implementation(kotlin(Libs.Kotlin.reflect))
    implementation(Libs.SpringBoot.starter)
}
