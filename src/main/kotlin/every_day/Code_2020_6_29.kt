package every_day

import swap

fun main(args: Array<String>) {
    println(findKthLargest(intArrayOf(3,2,1,5,6,4) , 2))
}

private fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = IntArray(k) { Int.MIN_VALUE }

    nums.forEach {
        minHeap.insertWithElement(it)
    }

    return minHeap.first()
}

private fun IntArray.insertWithElement(element: Int) {

    fun topElementChange() {
        var current = 0

        fun leftChild() = (current shl 1) + 1
        fun rightChild() = (current shl 1) + 2

        while (true) {
            val left = leftChild()
            val right = rightChild()

            val swapIndex = when {
                left < size && right < size -> {
                    if (this[left] < this[right]) {
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

            if (this[swapIndex] < this[current]) {
                swap(swapIndex, current)
            }

            current = swapIndex
        }
    }

    if (element <= first()) {
        return
    }

    this[0] = element
    topElementChange()
}

