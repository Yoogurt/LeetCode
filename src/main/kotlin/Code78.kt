package main.kotlin

fun main(args: Array<String>) {
    println(subsets(intArrayOf(1, 2, 3)))
}

private fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()


    fun select(currentSelect: MutableList<Int>, remain: MutableList<Int>) {
        result += ArrayList(currentSelect)

        if (remain.isEmpty()) {
            return
        }

        remain.forEachIndexed { index, element ->
            currentSelect += element
            select(currentSelect, if (index < remain.size) {
                remain.subList(index + 1, remain.size)
            } else {
                mutableListOf()
            })
            currentSelect.remove(element)
        }
    }

    select(mutableListOf(), nums.toMutableList().also {
        it.sort()
    })

    return result
}