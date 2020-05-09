fun main() {
    println(getLeastNumbers(intArrayOf(4, 5, 1, 6, 2, 7, 3, 8), 4).contentToString())
}

private fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
    if (arr.size <= k) {
        return arr
    }

    if (k <= 0) {
        return intArrayOf()
    }

    val maxHeap = IntArray(k) {
        Int.MAX_VALUE
    }

    arr.forEach {
        if (it < maxHeap[0]) {
            maxHeap[0] = it
            maxHeap.topHeapChange()
        }
    }

    return maxHeap
}

private inline fun leftOf(index: Int) = (index shl 1) + 1
private inline fun rightOf(index: Int) = (index shl 1) + 2

private fun IntArray.swap1(index1: Int, index2: Int) {
    this[index1] = this[index1] xor this[index2]
    this[index2] = this[index1] xor this[index2]
    this[index1] = this[index1] xor this[index2]
}

private fun IntArray.topHeapChange() {
    var parent = 0
    var left = leftOf(parent)
    var right = rightOf(parent)

    fun updateChild() {
        left = leftOf(parent)
        right = rightOf(parent)
    }

    while (true) {
        val biggerIndex = when {
            left < size && right < size -> {
                if (this[left] > this[right]) {
                    left
                } else {
                    right
                }
            }

            left < size -> {
                left
            }
            else -> {
                return
            }
        }

        if (this[parent] < this[biggerIndex]) {
            swap1(parent, biggerIndex)
            parent = biggerIndex
            updateChild()
        } else {
            return
        }
    }
}