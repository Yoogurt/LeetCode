package main.kotlin

import java.util.ArrayList

fun main(args: Array<String>) {
    println(permute(intArrayOf(1, 2, 3)))
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun select(path: MutableList<Int>, remain: MutableList<Int>) {
        if (remain.isEmpty()) {
            result += ArrayList(path)
            return
        }

        (0 until remain.size).forEach {
            val element = remain[it]

            path.add(element)
            remain.remove(element)

            select(path, remain)

            path.remove(element)
            remain.add(it, element)
        }
    }

    select(mutableListOf(), nums.toMutableList())

    return result
}