package son.ysy.photo.ext

fun String.hideWord(startIndex: Int, count: Int, hideWord: Char = '*'): String {
    val hideRange = startIndex.until(startIndex + count)
    return mapIndexed { index, c ->
        c.takeIf {
            index !in hideRange
        } ?: hideWord
    }.joinToString()
}