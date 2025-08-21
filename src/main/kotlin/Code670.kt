fun main() {
    println(maximumSwap(52345))
}

private fun maximumSwap(num: Int): Int {
    var num = num
    val nums = mutableListOf<Int>()

    while (num > 0) {
        nums += num % 10
        num /= 10
    }
    nums.reverse()

    for (bit in nums.indices) {
        if (bit >= nums.lastIndex) {
            break
        }

        var max = nums.last()
        var maxIndex = nums.lastIndex
        var indexed = nums.lastIndex - 1
        while (indexed > bit) {
            if (nums[indexed] > max) {
                max = nums[indexed]
                maxIndex = indexed
            }
            indexed--
        }

        if (max > nums[bit]) {
            nums[bit] = nums[bit] xor nums[maxIndex]
            nums[maxIndex] = nums[bit] xor nums[maxIndex]
            nums[bit] = nums[bit] xor nums[maxIndex]
            break
        }
    }

    return nums.fold(0) { left, right ->
        left * 10 + right
    }
}