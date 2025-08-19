import kotlin.math.max

fun main() {
    println(findLongestChain(arrayOf(
        intArrayOf(1,2),
        intArrayOf(7,8),
        intArrayOf(4,5),
    )))
}

fun findLongestChain(pairs: Array<IntArray>): Int {
    pairs.sortBy {
        it[0]
    }

    val data = IntArray(pairs.size) { 1 }
    var result = 1
    data.forEachIndexed { indexed, visit ->
        pairs.sliceArray(0..indexed - 1).forEachIndexed { prevIndexed, current ->
            if (current[1] < pairs[indexed][0]) {
                data[indexed] = max(data[prevIndexed] + 1, data[indexed])
            }
        }

        result = max(result, data[indexed])
    }

    return data.max()
}