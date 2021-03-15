import java.util.*

/**
 * 12
[[0, 1], [1, 2], [1, 3], [1, 10], [1, 11], [1, 4], [2, 4], [2, 6], [2, 9], [2, 10], [2, 4], [2, 5], [2, 10], [3, 7], [3, 7], [4, 5], [4, 11], [4, 11], [4, 10], [5, 7], [5, 10], [6, 8], [7, 11], [8, 10]]
2
3
 */
fun main() {
    println(
        findWhetherExistsPath(
            2,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(1, 2)),
            0,
            2
        )
    )
    println(
        findWhetherExistsPath(
            5,
            arrayOf(
                intArrayOf(0, 1), intArrayOf(0, 4),
                intArrayOf(0, 4), intArrayOf(0, 1),
                intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 4)
            ),
            0,
            3
        )
    )
}

private fun findWhetherExistsPath(n: Int, graph: Array<IntArray>, start: Int, target: Int): Boolean {
    val visited = TreeSet<Int>().also {
        it += start
    }

    graph.forEach {
        if (it.first() in visited) {
            visited += it[1]
        }
    }

    return target in visited
}