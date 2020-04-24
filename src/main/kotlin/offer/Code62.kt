package offer

fun main(args: Array<String>) {
    println(lastRemaining(10, 17))
}

private fun lastRemaining(n: Int, m: Int): Int {
    if (n == 1) {
        return 0
    }

    val indexAfterDeletion = lastRemaining(n - 1, m)
    return (m + indexAfterDeletion) % n
}