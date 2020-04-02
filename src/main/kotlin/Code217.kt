import java.util.*

fun main(args: Array<String>) {
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
}

private fun containsDuplicate(nums: IntArray): Boolean {
    val set = TreeSet<Int>()

    nums.forEach {
        if (set.contains(it)) {
            return true
        }
        set += it
    }

    return false
}