package main.kotlin.Tencent

fun main() {
    println(uniquePaths(7, 3))
}

fun uniquePaths(m: Int, n: Int): Int {
    val result = Array(m) {
        Array(n) {
            0
        }
    }

    repeat(m) {
        result[it][0] = 1
    }

    repeat(n) {
        result[0][it] = 1
    }

    for (rowIndex in (1 until m)) {
        for (columnIndex in (1 until n)) {
            result[rowIndex][columnIndex] = result[rowIndex - 1][columnIndex] + result[rowIndex][columnIndex - 1]
        }
    }

    return result.last().last()
}