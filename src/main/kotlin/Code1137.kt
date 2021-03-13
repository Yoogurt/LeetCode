fun main() {
    println(tribonacci(4))
    println(tribonacci(25))
}

/**
 *泰波那契序列 Tn 定义如下：
T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

示例 1：
输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

示例 2：
输入：n = 25
输出：1389537
 */

private fun tribonacci(n: Int): Int {
    when (n) {
        0 -> {
            return 0
        }
        1 -> {
            return 1
        }

        2 -> {
            return 1
        }
    }

    var first = 0
    var second = 1
    var third = 1

    repeat(n - 2) {
        third = (first + second + third).also {
            first = second
            second = third
        }
    }

    return third
}