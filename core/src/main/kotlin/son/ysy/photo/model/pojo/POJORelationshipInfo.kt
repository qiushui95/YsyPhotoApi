package son.ysy.photo.model.pojo

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import son.ysy.photo.mapper.DatabaseTables
import son.ysy.photo.model.pojo.BasePOJO

/**
 * 和杨时逸的关系POJO
 */
@TableName(DatabaseTables.RelationshipInfo.TABLE_NAME)
class POJORelationshipInfo(
        /**
         * 关系文本
         */
        @TableField(DatabaseTables.RelationshipInfo.FIELD_NAME_RELATIONSHIP)
        val relationship: String
) : BasePOJO()