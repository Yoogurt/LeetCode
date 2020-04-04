fun main(args: Array<String>) {
    print(intArrayOf(5, 4, 7, 8, 9, 3, 1).also {
        mergeSort(it)
    }.contentToString())
}

fun mergeSort(data: IntArray) {
    if (data.size <= 1) {
        return
    }

    val middleIndex = data.size ushr 1

    val left = data.copyOfRange(0, middleIndex)
    val right = data.copyOfRange(middleIndex, data.size)

    mergeSort(left)
    mergeSort(right)

    var leftIndex = 0
    var rightIndex = 0

    while (leftIndex < left.size && rightIndex < right.size) {
        val minOne = if (left[leftIndex] < right[rightIndex]) {
            left[leftIndex++]
        } else {
            right[rightIndex++]
        }

        data[leftIndex + rightIndex - 1] = minOne
    }

    while (leftIndex < left.size) {
        data[leftIndex + rightIndex] = left[leftIndex]
        leftIndex++
    }

    while (rightIndex < right.size) {
        data[leftIndex + rightIndex] = right[rightIndex]
        rightIndex++
    }
}