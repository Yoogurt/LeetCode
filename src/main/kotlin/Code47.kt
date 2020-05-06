fun main(args: Array<String>) {
    println(permuteUnique(intArrayOf(1, 1, 2, 2)))
}

private fun permuteUnique(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    fun select(current: MutableList<Int>, remain: MutableList<Int>) {
        if (remain.isEmpty()) {
            result += current.toList()
            return
        }

        var last: Int? = null
        for (index in remain.indices) {
            val data = remain[index]

            if (data != last) {
                current += data
                remain.removeAt(index)

                select(current, remain)

                current.removeAt(current.lastIndex)
                remain.add(index, data)
            }
            last = data
        }
    }

    select(mutableListOf(), nums.toMutableList())

    return result
}