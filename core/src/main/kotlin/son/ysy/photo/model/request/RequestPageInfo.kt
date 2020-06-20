package son.ysy.photo.model.request

import com.baomidou.mybatisplus.extension.plugins.pagination.Page

data class RequestPageInfo(val page: Long, val pageSize: Long) {
    inline fun <reified DATA : Any> toMybatisPage(): Page<DATA> {
        return Page<DATA>(page, pageSize, true)
    }
}