import java.util.*

fun main() {
    println(
        dijkstra(
            arrayOf(
                intArrayOf(-1, 7, 9, -1, -1, 14),
                intArrayOf(7, -1, 10, 15, -1, -1),
                intArrayOf(9, 10, -1, 11, -1, 2),
                intArrayOf(-1, 15, 11, -1, 6, -1),
                intArrayOf(-1, -1, -1, 6, -1, 9),
                intArrayOf(14, -1, 2, -1, 9, -1)
            ),
            0,
            3
        )
    )
}

private fun dijkstra(graph: Array<IntArray>, from: Int, to: Int): Int {
    val visitQueue = mutableListOf<Int>()
    visitQueue += from

    val result = IntArray(graph.size) { Int.MAX_VALUE }
    result[from] = 0

    while (visitQueue.isNotEmpty()) {
        val visitIndex = visitQueue.removeAt(0)

        if (visitIndex == to){
            break
        }

        graph[visitIndex].forEachIndexed { indexed, weight ->
            if (weight < 0 || indexed == from) {
                return@forEachIndexed
            }
            val originWeight = result[indexed]
            val newWeight = result[visitIndex] + weight
            if (newWeight < originWeight) {
                result[indexed] = newWeight
                if (newWeight < result[to] && indexed !in visitQueue) {
                    visitQueue += indexed
                }
            }
        }
    }

    return result[to]
}