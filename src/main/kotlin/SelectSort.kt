fun main(args: Array<String>) {
    val data = intArrayOf(5, 4, 3, 2, 1)
    selectSort(data)
    println(data.contentToString())
}


private fun selectSort(data: IntArray) {

    var minIndex: Int
    data.indices.forEach {
        minIndex = it

        (it + 1 until data.size).forEach { compareIndex ->
            if (data[compareIndex] < data[minIndex]) {
                minIndex = compareIndex
            }
        }

        data.swap(minIndex, it)
    }
}