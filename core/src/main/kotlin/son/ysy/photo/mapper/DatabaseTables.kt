package son.ysy.photo.mapper

object DatabaseTables {

    object Common {
        const val FIELD_ID: String = "id"
        const val FIELD_CREATE_TIME: String = "createTime"
        const val FIELD_UPDATE_TIME: String = "updateTime"
    }

    object ImageInfo {
        const val TABLE_NAME = "ImageInfo"
        const val FIELD_NAME_IMAGE_URL = "imageUrl"
        const val FIELD_NAME_WIDTH = "width"
        const val FIELD_NAME_HEIGHT = "height"
        const val FIELD_NAME_HAS_DELETE = "hasDelete"
        const val FIELD_NAME_IMAGE_TYPE = "imageType"
        const val FIELD_NAME_TAKE_TIME = "takeTime"
        const val FIELD_NAME_MD5 = "md5"
        const val FIELD_NAME_USER_ID = "userId"
    }

    object RelationshipInfo {
        const val TABLE_NAME = "RelationshipInfo"
        const val FIELD_NAME_RELATIONSHIP = "relationship"
    }

    object UserInfo {
        const val TABLE_NAME = "UserInfo"
        const val FIELD_NAME_PHONE = "phone"
        const val FIELD_NAME_AVATAR_ID = "avatarId"
        const val FIELD_NAME_RELATIONSHIP_ID = "relationshipId"
    }
}