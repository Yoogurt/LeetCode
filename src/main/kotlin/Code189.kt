fun main() {
    val nums = intArrayOf(1,2,3,4,5,6)
    // 3,4,5,6,1,2
    rotate(nums, 2)
    println(nums.joinToString(", "))
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

private fun rotate(nums: IntArray, k: Int): Unit {
    if (nums.isEmpty()) {
        return
    }

    var l = if (k < 0) {
        val remain = k % nums.size
        if (remain == 0) 0 else nums.size + remain
    } else {
        k % nums.size
    }

    if (l == 0) {
        return
    }

    val repeatCount = gcd(nums.size, l)
    repeat(repeatCount) {
        val beginIndex = nums.size - l + it
        var pointer = beginIndex

        fun targetIndexOf(target: Int) = (target + l) % nums.size

        var targetIndex = targetIndexOf(pointer)

        var temp = nums[targetIndex]
        nums[targetIndex] = nums[pointer]
        pointer = targetIndex

        while (pointer != beginIndex) {
            targetIndex = targetIndexOf(pointer)
            val tempValue = nums[targetIndex]
            nums[targetIndex] = temp
            temp = tempValue
            pointer = targetIndex
        }
    }
}