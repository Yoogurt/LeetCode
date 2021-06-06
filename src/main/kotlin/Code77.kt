import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(combine(3, 2))
}

private fun combine(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    combine(1, k, n, Stack(), result)
    return result
}

private fun combine(current: Int, k: Int, n: Int, currentPath: Stack<Int>, result: MutableList<MutableList<Int>>) {
    if (currentPath.size >= k) {
        result += ArrayList(currentPath)
        return
    }

    if(n - current >= k - currentPath.size) {
        combine(current + 1, k, n, currentPath, result)
    }

    currentPath.push(current)
    combine(current + 1, k, n, currentPath, result)
    currentPath.pop()
}