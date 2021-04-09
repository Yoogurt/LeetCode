package sourcedebug

fun main() {
//    val a = test1<String>(1)
//    println(a)
    val b = test2<String>(1)
    println(b)
    val c = test3<String>(1)
    println(c)
}

private fun <R> test1(any: Any): R? {
    return any as? R
}

private inline fun <R> test2(any: Any): R? {
    return any as? R
}

private inline fun <reified R> test3(any: Any): R? {
    return any as? R
}