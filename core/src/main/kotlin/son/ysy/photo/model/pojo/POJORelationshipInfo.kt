package son.ysy.photo.model.pojo

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import son.ysy.photo.model.pojo.BasePOJO

/**
 * 和杨时逸的关系POJO
 */
@TableName("RelationshipInfo")
class POJORelationshipInfo(
        /**
         * 关系文本
         */
        @TableField("relationship")
        val relationship: String
) : BasePOJO()