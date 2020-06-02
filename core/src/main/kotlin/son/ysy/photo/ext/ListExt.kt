package son.ysy.photo.ext

inline fun <reified T : Any> List<T>.subListNotIn(list: List<T>) = filterNot {
    list.contains(it)
}

inline fun <reified T : Any> List<T>.subListIn(list: List<T>) = filter {
    list.contains(it)
}