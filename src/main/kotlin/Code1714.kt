fun main() {
    println(smallestK(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 5).contentToString())
}

private fun smallestK(arr: IntArray, k: Int): IntArray {

    if (k == 0) return intArrayOf()

    fun leftChild(index: Int) = (index shl 1) + 1
    fun rightChild(index: Int) = (index shl 1) + 2

    val result = IntArray(k) { Int.MAX_VALUE }

    fun adjust() {
        var index = 0
        var leftChild = 0
        var rightChild = 0
        fun updateIndex() {
            leftChild = leftChild(index)
            rightChild = rightChild(index)
        }

        while (true) {
            updateIndex()

            val switchIndex = when {
                leftChild < result.size && rightChild < result.size -> {
                    val left = result[leftChild]
                    val right = result[rightChild]

                    if (left < right) rightChild else leftChild
                }

                leftChild < result.size -> {
                    leftChild
                }

                else -> return
            }

            if (result[index] < result[switchIndex]) {
                val temp = result[index]
                result[index] = result[switchIndex]
                result[switchIndex] = temp
            } else {
                return
            }
            index = switchIndex
        }
    }

    arr.forEach {
        if (it < result.first()) {
            result[0] = it
            adjust()
        }
    }

    return result
}