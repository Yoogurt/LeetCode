fun main(args: Array<String>) {
    print(intArrayOf(5, 4, 7, 8, 9, 3, 1).also {
        heapSort(it)
    }.contentToString())
}

private inline fun parentOf(child: Int) = (child - 1) ushr 1

private fun heapify(data: IntArray, endIndex: Int) {
    for (index in endIndex downTo 1) {
        if (data[parentOf(index)] < data[index]) {
            data.swap(parentOf(index), index)
        }
    }
}

fun heapSort(data: IntArray) {
    var lastIndex = data.lastIndex

    while (lastIndex > 0) {
        heapify(data, lastIndex)
        data.swap(lastIndex, 0)
        lastIndex--
    }
}