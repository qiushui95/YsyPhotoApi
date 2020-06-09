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
        const val kapt = "kapt"
        const val spring = "plugin.spring"
    }

    //spring
    object Spring {
        const val plugin = "io.spring.dependency-management"
    }

    //springBoot
    object SpringBoot {
        const val group = "org.springframework.boot"
        const val starterWeb = "$group:spring-boot-starter-web"
        const val starterWebFlux = "$group:spring-boot-starter-webflux"
        const val starterTest = "$group:spring-boot-starter-test"
        const val configuration = "$group:spring-boot-configuration-processor"
        const val cache = "$group:spring-boot-starter-cache"
        const val starterRedis = "$group:spring-boot-starter-data-redis"
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
    object Gson {
        const val core = "com.google.code.gson:gson:${Versions.gson}"
    }

    //MybatisPlus
    object MybatisPlus {
        private const val group = "com.baomidou"
        const val springBoot = "$group:mybatis-plus-boot-starter:${Versions.mybatisPlus}"
    }

    //mysql
    object Mysql {
        const val connector = "mysql:mysql-connector-java"
    }

    object QiNiu {
        private const val group = "com.qiniu:qiniu-java-sdk"
        const val core = "$group:${Versions.qiNiu}"
    }
}
