package main.kotlin

import kotlin.math.pow

fun main(args: Array<String>) {
    println(grayCode(2))
}

private fun grayCode(n: Int): List<Int> {
    val result = mutableListOf<Int>()

    repeat(2.0.pow(n).toInt()) {
        result += (it shr 1) xor it
    }
    return result
}