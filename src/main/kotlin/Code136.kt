fun main(args: Array<String>) {
    println(singleNumber(intArrayOf(2, 2, 4, 1, 1, 3, 4)))
}

fun singleNumber(nums: IntArray): Int =
    nums.fold(0) { left, right ->
        left xor right
    }