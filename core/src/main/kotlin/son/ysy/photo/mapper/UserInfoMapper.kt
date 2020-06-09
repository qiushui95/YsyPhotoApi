package son.ysy.photo.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import son.ysy.photo.model.pojo.POJOImageInfo
import son.ysy.photo.model.pojo.POJOUserInfo

interface UserInfoMapper : BaseMapper<POJOUserInfo>