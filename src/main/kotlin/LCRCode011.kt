import kotlin.math.max

fun main() {
    println(findMaxLength(intArrayOf(1,0,0, 0,1)))
}

private fun findMaxLength(nums: IntArray): Int {
    val zeroCount = IntArray(nums.size) { 0 }
    val oneCount = IntArray(nums.size) { 0 }

    nums.forEachIndexed { index, i ->
        if (i == 0) {
            zeroCount[index]++
        } else {
            oneCount[index]++
        }

        if (index > 0) {
            zeroCount[index] += zeroCount[index - 1]
            oneCount[index] += oneCount[index - 1]
        }
    }

    var result = 0

    for (cur in nums.lastIndex downTo 1) {
        if (zeroCount[cur] == oneCount[cur]) {
            if (cur + 1 > result) {
                return cur + 1
            }
        }

        for (it in 0 until cur) {
            val zeroCount = zeroCount[cur] - zeroCount[it]
            val oneCount = oneCount[cur] - oneCount[it]

            if (zeroCount == oneCount) {
                val length = cur - it
                if (length > result) {
                    result = length
                    break
                }
            }
        }
    }

    return result
}