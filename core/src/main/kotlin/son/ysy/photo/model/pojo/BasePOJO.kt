package son.ysy.photo.model.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.util.*

abstract class BasePOJO {
    /**
     * uuid 36
     */
    @TableId(COLUMN_NAME_ID, type = IdType.ASSIGN_UUID)
    var id: String = UUID.randomUUID().toString()

    companion object {
        const val COLUMN_NAME_ID = "id"
    }
}