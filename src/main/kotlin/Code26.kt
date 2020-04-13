package main.kotlin

fun main(args: Array<String>) {
    var data = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)

    data = data.copyOfRange(0, removeDuplicates(data))
    println(data.contentToString())
}

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 1) {
        return nums.size
    }

    var replaceIndex = 1
    var currentElement = nums.first()

    for (index in 1 until nums.size) {
        if (nums[index] != currentElement) {
            nums[replaceIndex] = nums[index]
            currentElement = nums[index]

            replaceIndex++
        }
    }

    return replaceIndex
}