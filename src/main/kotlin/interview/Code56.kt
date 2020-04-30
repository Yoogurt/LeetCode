package interview

fun main(args: Array<String>) {
    println(singleNumbers(intArrayOf(4, 4, 1, 2, 6, 2)).contentToString())
}

private fun singleNumbers(nums: IntArray): IntArray {
    val result = IntArray(2)

    val xorResult = nums.fold(0) { left, right ->
        left xor right
    }

    var differenceBit = 1
    while ((xorResult and differenceBit) == 0) {
        differenceBit = differenceBit shl 1
    }

    nums.forEach {
        if (it and differenceBit != 0) {
            result[0] = result[0] xor it
        } else {
            result[1] = result[1] xor it
        }
    }

    return result
}