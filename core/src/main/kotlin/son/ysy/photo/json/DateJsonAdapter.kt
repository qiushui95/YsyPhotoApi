package son.ysy.photo.json

import com.google.gson.*
import java.lang.reflect.Type
import java.util.*

class DateJsonAdapter : JsonSerializer<Date> {
    override fun serialize(src: Date?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return if (src == null) {
            JsonNull.INSTANCE
        } else {
            JsonPrimitive(src.time)
        }
    }
}