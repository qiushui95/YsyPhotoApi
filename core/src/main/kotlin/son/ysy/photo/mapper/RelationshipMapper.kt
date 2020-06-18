package son.ysy.photo.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import son.ysy.photo.model.pojo.POJORelationshipInfo

@Mapper
interface RelationshipMapper : BaseMapper<POJORelationshipInfo>