package main.kotlin

import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    println(climbStairs2(8))
}

fun climbStairs(n: Int): Int {
    return when (n) {
        1 -> {
            1
        }
        2 -> {
            2
        }
        else -> {
            var result = 0
            var temp = 1
            var temp2 = 2
            repeat(n - 2) {
                result = temp + temp2
                temp = temp2
                temp2 = result
            }

            result
        }
    }
}

private fun climbStairs2(n: Int): Int {
    return (1.0 / sqrt(5.0) * (((1 + sqrt(5.0)) / 2.0).pow(n + 1) - ((1 - sqrt(5.0)) / 2.0).pow(n + 1))).toInt()
}