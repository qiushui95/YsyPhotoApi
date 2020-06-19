package son.ysy.photo.core

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.google.gson.Gson
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import son.ysy.photo.controller.UserInfoController
import son.ysy.photo.mapper.ImageInfoMapper
import son.ysy.photo.mapper.ImageType
import son.ysy.photo.mapper.UserUploadMapper
import son.ysy.photo.model.tables.POJOImageInfo
import son.ysy.photo.model.vo.UserUploadRecordVo
import java.util.*
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest
class ImageInfoMapperTest {


    @Resource
    private lateinit var imageInfoMapper: ImageInfoMapper

    @Resource
    private lateinit var userUploadMapper: UserUploadMapper

    @Autowired
    private lateinit var gson: Gson

    @Test
    fun insertMore() {
        0.until(1000)
                .map {
                    POJOImageInfo(it.toString(), it * 1, it + 2, false, ImageType.Photo.type, Date(), it.toString(), "d6616b21-5360-4fb3-b4a4-49d5ef386568")
                }
                .forEach {
                    imageInfoMapper.insert(it)
                }
    }

    @Test
    fun selectByPage() {
        val imageList = userUploadMapper.selectUserUploadRecord(Page<UserUploadRecordVo>(2L, 10L), "d6616b21-5360-4fb3-b4a4-49d5ef386568")
        println(gson.toJson(imageList))
    }

    @Test
    fun testController() {

    }
}