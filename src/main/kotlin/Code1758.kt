import kotlin.math.min

fun main() {
    println(minOperations("101") == 0)
    println(minOperations("10101") == 0)
    println(minOperations("0111001") == 3)
}

/**
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。

交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。

返回使 s 变成 交替字符串 所需的 最少 操作数。
 */

private fun minOperations(s: String): Int {
    var zeroStart = 0
    var oneStart = 0

    s.forEachIndexed { indexed, c ->
        if (indexed and 1 == 0) {
            when (c) {
                '0' -> {
                    oneStart++
                }
                '1' -> {
                    zeroStart++
                }
            }
        } else {
            when (c) {
                '1' -> {
                    oneStart++
                }
                '0' -> {
                    zeroStart++
                }
            }
        }
    }

    return min(zeroStart, oneStart)
}