package son.ysy.photo.core

import org.junit.Test
import son.ysy.photo.ext.subListIn
import son.ysy.photo.ext.subListNotIn
import java.util.*

class ListTest {

    @Test
    fun testNotIn() {
        val list1 = listOf(0, 1, 2, 3, 4, 5, 6)
        val list2 = listOf(4, 5, 6, 7, 8, 9)
        println(list1.subListNotIn(list2))
        println(list1.subListIn(list2))
        println(UUID.randomUUID().toString())
    }
}