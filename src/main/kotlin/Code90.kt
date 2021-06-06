import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(subsetsWithDup(intArrayOf(1, 2, 2)))
    println(subsetsWithDup(intArrayOf(0)))
}

private  fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = mutableListOf<MutableList<Int>>()
    subSet(nums, 0, Stack(), result)
    return result
}

private  fun subSet(data: IntArray, index: Int, currentPath: Stack<Int>, result: MutableList<MutableList<Int>>) {
    if (index >= data.size) {
        result += ArrayList(currentPath)
        return
    }

    val path = data[index]
    if(path != data.getOrNull(index - 1) || currentPath.isEmpty() ||  currentPath.peek() != path){
        subSet(data, index + 1, currentPath, result)
    }

    currentPath.push(path)
    subSet(data, index + 1, currentPath, result)
    currentPath.pop()
}