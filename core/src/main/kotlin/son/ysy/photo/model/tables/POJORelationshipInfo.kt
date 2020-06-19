package son.ysy.photo.model.tables

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import son.ysy.photo.mapper.DatabaseTables

/**
 * 和杨时逸的关系POJO
 */
@TableName(DatabaseTables.RelationshipInfo.TABLE_NAME)
data class POJORelationshipInfo(
        /**
         * 关系文本
         */
        @TableField(DatabaseTables.RelationshipInfo.FIELD_NAME_RELATIONSHIP)
        val relationship: String
) : BasePOJO()