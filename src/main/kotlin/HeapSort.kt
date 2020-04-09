fun main(args: Array<String>) {
    print(intArrayOf(5, 4, 7, 8, 8, 9, 3, 1).also {
        heapSort(it)
    }.contentToString())
}

private inline fun parentOf(child: Int) = if (child == 0) {
    0
} else {
    (child - 1) ushr 1
}

private inline fun leftChildOf(parent: Int) = (parent shl 1) + 1
private inline fun rightChildOf(parent: Int) = (parent shl 1) + 2

private fun heapify(data: IntArray) {
    fun elevateParent(index: Int) {
        var index = index
        var parent = parentOf(index)

        while (parent != index) {
            if (data[parent] < data[index]) {
                data.swap(parent, index)
                index = parent
                parent = parentOf(index)
            } else {
                return
            }
        }
    }

    (0..data.lastIndex).forEach {
        elevateParent(it)
    }
}

private fun reorder(data: IntArray, lastIndex: Int) {
    var current = 0
    var leftChild = leftChildOf(current)
    var rightChild = rightChildOf(current)

    fun updateChildIndex() {
        leftChild = leftChildOf(current)
        rightChild = rightChildOf(current)
    }

    while (true) {
        val biggerOneIndex = when {
            leftChild <= lastIndex && rightChild <= lastIndex -> {
                if (data[leftChild] > data[rightChild]) {
                    leftChild
                } else {
                    rightChild
                }
            }

            leftChild <= lastIndex -> {
                leftChild
            }

            else -> {
                return
            }
        }

        if (data[current] < data[biggerOneIndex]) {
            data.swap(current, biggerOneIndex)
        }

        current = biggerOneIndex
        updateChildIndex()
    }
}

fun heapSort(data: IntArray) {
    var lastIndex = data.lastIndex
    heapify(data)

    while (lastIndex > 0) {
        reorder(data, lastIndex)
        data.swap(lastIndex, 0)
        lastIndex--
    }
}