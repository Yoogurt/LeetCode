package main.kotlin

fun main(args: Array<String>) {
    println(threeSum(intArrayOf(-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6)))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if (nums.isEmpty()) {
        return result
    }

    val checked = mutableSetOf<Int>()
    nums.sort()

    nums.forEachIndexed { indexed, target ->
        if (!checked.contains(target)) {
            checked += target

            if (indexed > nums.lastIndex) {
                return@forEachIndexed
            }

            val sumList = sumOf(nums.copyOfRange(indexed + 1, nums.size), -target)
            if (sumList.isNotEmpty()) {
                result += sumList.map {
                    it.add(0, target)
                    it
                }
            }
        }
    }


    return result
}

private fun sumOf(nums: IntArray, target: Int): MutableList<MutableList<Int>> {
    var left = 0
    var right = nums.lastIndex
    val result = mutableListOf<MutableList<Int>>()

    loop@ while (left < right) {
        val sum = nums[left] + nums[right]

        when {
            sum > target -> {
                right--
            }
            sum < target -> {
                left++
            }
            else -> {
                result += mutableListOf(nums[left], nums[right])

                val currentLeft = nums[left++]
                while (left < right && nums[left] == currentLeft) {
                    left++
                }

                val currentRight = nums[right--]
                while (left < right && nums[right] == currentRight) {
                    right--
                }

                if (left < right) {
                    val leftMove = sumOf(nums.copyOfRange(left, right + 1), target)

                    if (leftMove.isNotEmpty()) {
                        result.addAll(leftMove)
                    }
                }

                break@loop
            }
        }
    }

    return result
}