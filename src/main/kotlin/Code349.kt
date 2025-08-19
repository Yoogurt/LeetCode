fun main() {
    println(intersection(intArrayOf(6, 5, 2, 3, 3), intArrayOf(1, 2, 3)).joinToString(", "))
}

private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val hash = BooleanArray(1000) { false }

    nums1.forEach {
        hash[it] = true
    }

    val result = mutableSetOf<Int>()
    nums2.forEach {
        if (hash[it]) {
            result += it
        }
    }

    return result.toIntArray()
}