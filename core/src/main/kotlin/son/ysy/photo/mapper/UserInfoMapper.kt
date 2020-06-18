package son.ysy.photo.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import son.ysy.photo.model.pojo.POJOImageInfo
import son.ysy.photo.model.pojo.POJOUserInfo
import son.ysy.photo.model.response.ResponseUserInfo

interface UserInfoMapper : BaseMapper<POJOUserInfo>