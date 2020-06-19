package son.ysy.photo.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import son.ysy.photo.model.vo.UserUploadRecordVo

@Mapper
interface UserUploadMapper : BaseMapper<UserUploadRecordVo> {
    @Select("select id,imageUrl,width,height,takeTime,createTime as uploadTime from ImageInfo where userId=#{userId}")
    fun selectUserUploadRecord(page: Page<*>, userId: String): Page<UserUploadRecordVo>
}