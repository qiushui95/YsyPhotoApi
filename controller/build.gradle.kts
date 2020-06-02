plugins {
    kotlin(Libs.Kotlin.jvm)
    id(Libs.SpringBoot.plugin)
    id(Libs.Spring.plugin)

}

dependencies {
    implementation(project(Libs.Module.util))
    implementation(kotlin(Libs.Kotlin.stdlib))
    implementation(kotlin(Libs.Kotlin.reflect))
    implementation(Libs.SpringBoot.starterWebflux)
    testImplementation(Libs.SpringBoot.starterTest) {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    implementation(Libs.Coroutines.reactor)
    testImplementation(Libs.Coroutines.reactorTest)
}