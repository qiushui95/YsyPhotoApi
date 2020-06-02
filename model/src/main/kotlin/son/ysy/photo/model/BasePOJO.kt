package son.ysy.photo.model

import java.util.*

abstract class BasePOJO {
    /**
     * uuid 36
     */
    var id: String = UUID.randomUUID().toString()
}