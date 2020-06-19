package son.ysy.photo.json

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.google.gson.*
import java.lang.reflect.Type

class PageJsonAdapter : JsonSerializer<Page<*>> {
    override fun serialize(src: Page<*>?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonObject().apply {
            src?.also { page ->
                add("currentPage", JsonPrimitive(page.current))
                add("totalCount", JsonPrimitive(page.total))
                add("pageSize", JsonPrimitive(page.size))
                add("list", context?.serialize(page.records))
            }
        }
    }
}