object Libs {

    object Util {
        //时间处理
        const val joda = "joda-time:joda-time:2.10.6"
    }

    //kotlin
    object Kotlin {
        const val stdlib = "stdlib-jdk8"
        const val reflect = "reflect"
        const val jvm = "jvm"
        const val spring = "plugin.spring"
    }

    //模块
    object Module {
        const val app=":app"
        const val util=":util"
        const val controller=":controller"
        const val model=":model"
        const val service=":service"
    }

    //spring
    object Spring {
        const val plugin = "io.spring.dependency-management"
    }

    //springBoot
    object SpringBoot {
        const val plugin = "org.springframework.boot"
        const val starter = "$plugin:spring-boot-starter"
        const val starterWebflux = "$plugin:spring-boot-starter-webflux"
        const val starterTest = "$plugin:spring-boot-starter-test"
    }

    //协程
    object Coroutines {
        private const val group = "org.jetbrains.kotlinx"
        const val core = "$group:kotlinx-coroutines-core:${Versions.coroutines}"
        const val test = "$group:kotlinx-coroutines-test:${Versions.coroutines}"
        const val reactor = "$group:kotlinx-coroutines-reactor:${Versions.coroutines}"
        const val reactorTest = "io.projectreactor:reactor-test"
    }

    //依赖注入框架
    object Koin {
        const val core = "org.koin:koin-core:${Versions.koin}"
        const val test = "org.koin:koin-test:${Versions.koin}"
    }

    //json处理
    object MoShi {
        const val core = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val plugin = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }
}
