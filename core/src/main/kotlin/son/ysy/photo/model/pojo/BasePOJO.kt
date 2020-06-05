package son.ysy.photo.model.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import son.ysy.photo.mapper.DatabaseTables
import java.util.*

abstract class BasePOJO {
    /**
     * uuid 36
     */
    @TableId(DatabaseTables.Common.FIELD_ID, type = IdType.ASSIGN_UUID)
    var id: String = UUID.randomUUID().toString()
}