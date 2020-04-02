fun main() {
    print(productExceptSelf(intArrayOf(1, 2, 3, 4)).contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val ret = IntArray(nums.size) { 1 }

    var currentMultiple = 1

    nums.forEachIndexed { index, it ->
        ret[index] = currentMultiple
        currentMultiple *= it
    }

    currentMultiple = 1
    for (index in ret.lastIndex downTo 0) {
        ret[index] = currentMultiple * ret[index]
        currentMultiple *= nums[index]
    }

    return ret
}