fun main(args: Array<String>) {
    print(intArrayOf(5, 4, 7, 8, 9, 3, 1).also {
        quickSort2(it, 0, it.lastIndex)
    }.contentToString())
}

fun quickSort(data: IntArray, left: Int, right: Int) {
    if (left >= right) {
        return
    }

    val key = data[left]
    var leftIndexed = left
    var rightIndexed = right

    while (leftIndexed < rightIndexed) {

        while (leftIndexed < rightIndexed) {
            if (data[rightIndexed] < key) {
                data[leftIndexed++] = data[rightIndexed]
                break
            } else {
                rightIndexed--
            }
        }

        while (leftIndexed < rightIndexed) {
            if (data[leftIndexed] > key) {
                data[rightIndexed--] = data[leftIndexed]
                break
            } else {
                leftIndexed++
            }
        }

    }

    assert(leftIndexed == rightIndexed)
    data[leftIndexed] = key
    quickSort(data, left, leftIndexed - 1)
    quickSort(data, rightIndexed + 1, right)
}

fun quickSort2(data: IntArray, start: Int, end: Int){
    if (start >= end) {
        return
    }

    var startIndex = start;
    var endIndex = end;

    while (startIndex < endIndex) {
        while (data[startIndex] < data[endIndex]) {
            endIndex--
        }
        if (startIndex != endIndex) {
            data.swap(startIndex++, endIndex);
        }

        if (startIndex >= endIndex) {
            break
        }

        while (data[startIndex] < data[endIndex]) {
            startIndex++
        }
        if (startIndex != endIndex) {
            data.swap(startIndex, endIndex--);
        }
    }

    quickSort2(data, start, startIndex - 1)
    quickSort2(data, startIndex + 1, end)
}