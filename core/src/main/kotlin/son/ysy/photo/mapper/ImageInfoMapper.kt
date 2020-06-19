package son.ysy.photo.mapper

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.apache.ibatis.annotations.Mapper
import son.ysy.photo.model.tables.POJOImageInfo

@Mapper
interface ImageInfoMapper : BaseMapper<POJOImageInfo> {
    fun getImageList(page: Page<POJOImageInfo>, query: QueryWrapper<POJOImageInfo>?): IPage<POJOImageInfo>
}