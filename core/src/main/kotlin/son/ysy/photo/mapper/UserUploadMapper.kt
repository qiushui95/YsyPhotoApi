package son.ysy.photo.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import son.ysy.photo.model.vo.UserUploadRecordVo

@Mapper
interface UserUploadMapper : BaseMapper<UserUploadRecordVo> {
    @Select("select" +
            " ${DatabaseTables.ImageInfo.TABLE_NAME}.id," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.imageUrl," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.width," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.height," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.takeTime," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.createTime as uploadTime" +
            " from " +
            DatabaseTables.ImageInfo.TABLE_NAME +
            " where" +
            " ${DatabaseTables.ImageInfo.TABLE_NAME}.${DatabaseTables.ImageInfo.FIELD_NAME_USER_ID}=#{userId}"
    )
    fun selectMineUploadRecord(page: Page<*>, userId: String): Page<UserUploadRecordVo>

    @Select("select" +
            " ${DatabaseTables.ImageInfo.TABLE_NAME}.id," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.imageUrl," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.width," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.height," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.takeTime," +
            "${DatabaseTables.ImageInfo.TABLE_NAME}.createTime as uploadTime," +
            "${DatabaseTables.RelationshipInfo.TABLE_NAME}.${DatabaseTables.RelationshipInfo.FIELD_NAME_RELATIONSHIP}" +
            " from " +
            "${DatabaseTables.ImageInfo.TABLE_NAME}," +
            "${DatabaseTables.UserInfo.TABLE_NAME}," +
            DatabaseTables.RelationshipInfo.TABLE_NAME +
            " where" +
            " ${DatabaseTables.ImageInfo.TABLE_NAME}.${DatabaseTables.ImageInfo.FIELD_NAME_USER_ID}=#{userId}" +
            " and" +
            " ${DatabaseTables.ImageInfo.TABLE_NAME}.${DatabaseTables.ImageInfo.FIELD_NAME_USER_ID}=${DatabaseTables.UserInfo.TABLE_NAME}.${DatabaseTables.Common.FIELD_ID}" +
            " and" +
            " ${DatabaseTables.UserInfo.TABLE_NAME}.${DatabaseTables.UserInfo.FIELD_NAME_RELATIONSHIP_ID}=${DatabaseTables.RelationshipInfo.TABLE_NAME}.${DatabaseTables.Common.FIELD_ID}"
    )
    fun selectUserUploadRecord(page: Page<*>, userId: String): Page<UserUploadRecordVo>
}