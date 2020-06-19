package son.ysy.photo.service.user

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import son.ysy.photo.model.response.ResponseUserInfo
import son.ysy.photo.model.vo.UserUploadRecordVo

interface IUserInfoService {

    fun getUserInfo(userId: String): ResponseUserInfo

    fun getUploadRecord(page: Page<*>, userId: String): Page<UserUploadRecordVo>
}