fun main(args: Array<String>) {
    val data = intArrayOf(3, 1, 5, 6,7)
    insertSort(data)
    println(data.contentToString())
}

private fun insertSort(data: IntArray) {
    data.forEachIndexed { indexed, it ->

        if (indexed == 0) {
            return@forEachIndexed
        }


        var insertIndex = indexed

        while (insertIndex > 0 && it < data[insertIndex - 1]) {
            insertIndex--
        }

        (indexed downTo insertIndex + 1).forEach {
            data[it] = data[it - 1]
        }

        data[insertIndex] = it
    }
}