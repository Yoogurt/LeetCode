package offer

fun main() {
    println(isStraight(intArrayOf(0,0,1,2,4,0,3)))
}

private fun isStraight(nums: IntArray): Boolean {
    var last = 0

    return nums.all {
        if (it == 0 || it >= last) {
            if (it != 0) {
                last = it
            }

            true
        } else {
            false
        }
    }
}