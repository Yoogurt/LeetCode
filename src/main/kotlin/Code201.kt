fun main() {
    println(rangeBitwiseAnd(5, 7))
    println(rangeBitwiseAnd(0, 0))
    println(rangeBitwiseAnd(1, 2147483647))
}

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。

示例 1：
输入：left = 5, right = 7
输出：4

示例 2：
输入：left = 0, right = 0
输出：0

示例 3：
输入：left = 1, right = 2147483647
输出：0
 */

private fun rangeBitwiseAnd(left: Int, right: Int): Int {
    return (left until right).fold(right) { left, right ->
        if (left == 0) {
            return 0
        }

        left and right
    }
}