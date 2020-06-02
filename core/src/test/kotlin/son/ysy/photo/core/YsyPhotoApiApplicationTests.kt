package son.ysy.photo.core

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import son.ysy.photo.property.QiNiuProperty


@RunWith(SpringRunner::class)
@SpringBootTest
class YsyPhotoApiApplicationTests {

    @Autowired
    lateinit var qiNiuProperty: QiNiuProperty

    @Test
    fun contextLoads() {
        println("========================================")
        val start = System.currentTimeMillis()
        println(qiNiuProperty)
        println(System.currentTimeMillis() - start)
    }

}
