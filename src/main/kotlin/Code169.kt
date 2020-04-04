fun main(args: Array<String>) {
    println(majorityElement(intArrayOf(1 , 2,2)))
}

private fun majorityElement(nums: IntArray): Int {
    val map = hashMapOf<Int, Int>()

    val halfOfNumberSize = (nums.size + 1) ushr 1

    nums.forEach { num ->
        map.put(num, ((map.get(num) ?: 0) + 1).also {
            if (it >= halfOfNumberSize) {
                return num
            }
        })
    }

    return -1
}
