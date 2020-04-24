fun main(args: Array<String>) {
    val data = intArrayOf(2, 0, 1)
    sortColors(data)
    println(data.contentToString())
}

private fun sortColors(data: IntArray) {
    if (data.isEmpty()) {
        return
    }

    var left = 0
    var right = data.lastIndex
    var current = 0

    while (current <= right) {
        when {
            data[current] == 0 -> {
                data.swap(left++, current++)
            }

            data[current] == 2 -> {
                data.swap(current, right--)
            }

            else -> {
                current++
            }
        }
    }
}