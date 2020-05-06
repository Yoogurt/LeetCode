fun main(args: Array<String>) {
    println(removeElement(intArrayOf(3, 2, 2, 3), 5))
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    var placeIndex = 0

    nums.forEachIndexed { index, it ->
        if (it != `val`) {
            nums[placeIndex++] = it
        }
    }

    return placeIndex
}