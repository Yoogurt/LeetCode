fun main() {
    println(
        xorQueries(
            intArrayOf(1, 3, 4, 8),
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3))
        ).contentToString()
    )
}

private fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
    val prefixXor = run {
        var preXor = 0

        arr.map {
            (preXor xor it).also {
                preXor = it
            }
        }
    }

    val result = IntArray(queries.size)

    queries.forEachIndexed { index, ints ->
        result[index] = prefixXor[ints[1]] xor (prefixXor.getOrNull(ints[0] - 1) ?: 0)
    }

    return result
}