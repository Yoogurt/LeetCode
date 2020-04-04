fun main(args: Array<String>) {
    print(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    print(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}

private fun parentOf(childIndex: Int) = (childIndex - 1) shr 1

private fun leftChildOf(parentIndex: Int) = (parentIndex shl 1) + 1
private fun rightChildOf(parentIndex: Int) = (parentIndex shl 1) + 2

private fun findKthLargest(nums: IntArray, k: Int): Int {
    if (k > nums.size) {
        throw IllegalArgumentException()
    }

    val topHeap = IntArray(k) {
        Int.MIN_VALUE
    }
    nums.forEachIndexed { indexed, it ->
        if (it > topHeap.first()) {
            topHeap[0] = it
            topHeap.reorder(0)
        }
    }

    return topHeap.first()
}

private fun IntArray.reorder(index: Int) {
    var current = index
    var leftChildIndex = leftChildOf(current)
    var rightChildIndex = rightChildOf(current)

    loop@ while (true) {
        val compareIndex = when {
            leftChildIndex < size && rightChildIndex < size -> {
                if (this[leftChildIndex] < this[rightChildIndex]) {
                    leftChildIndex
                } else {
                    rightChildIndex
                }
            }

            leftChildIndex < size -> {
                leftChildIndex
            }

            else -> {
                break@loop
            }
        }

        current = if (this[compareIndex] < this[current]) {
            swap(compareIndex, current)
            compareIndex
        } else {
            break@loop
        }

        leftChildIndex = leftChildOf(current)
        rightChildIndex = rightChildOf(current)
    }
}