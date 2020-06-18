package son.ysy.photo.core

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import son.ysy.photo.mapper.RelationshipMapper
import son.ysy.photo.mapper.UserInfoMapper
import son.ysy.photo.property.QiNiuProperty


@RunWith(SpringRunner::class)
@SpringBootTest
class YsyPhotoApiApplicationTests {

    @Autowired
    private lateinit var qiNiuProperty: QiNiuProperty

    @Autowired
    private lateinit var userInfoMapper: UserInfoMapper



    @Test
    fun contextLoads() {
        val start = System.currentTimeMillis()
        val list = userInfoMapper.selectList(null)
        println(list.joinToString { it.id })
        println(System.currentTimeMillis() - start)
    }

}
