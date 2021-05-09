fun main(args: Array<String>) {
    println(rob(intArrayOf(2, 1, 1, 2)))
}

private fun rob(nums: IntArray): Int {
    var max = 0

    if (nums.isEmpty()) {
        return 0
    }

    var room1 = nums[0]

    if (nums.size <= 1) {
        return room1
    }

    var room2 = kotlin.math.max(room1, nums[1])

    if (nums.size <= 2) {
        return kotlin.math.max(room1, nums[1])
    }

    (2 until nums.size).forEach {
        max = kotlin.math.max(room1 + nums[it], room2)
        room1 = room2
        room2 = max
    }

    return max
}