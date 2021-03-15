import java.util.*

fun main() {
    println(
        allPathsSourceTarget(
            arrayOf(

            )
        )
    )
}

private fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    allPathsSourceTarget(0, Stack(), graph, result)
    return result
}

private fun allPathsSourceTarget(
    currentNode: Int,
    currentPath: Stack<Int>,
    graph: Array<IntArray>,
    result: MutableList<List<Int>>
) {
    try {
        currentPath.push(currentNode)
        if (currentNode == graph.lastIndex) {
            result += currentPath.toList()
            return
        }

        graph[currentNode].forEach {
            allPathsSourceTarget(it, currentPath, graph, result)
        }
    } finally {
        currentPath.pop()
    }
}