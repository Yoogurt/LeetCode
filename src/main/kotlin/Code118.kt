fun main() {
    println(generate(0))
}

private fun generate(numRows: Int): List<List<Int>> {
    if (numRows < 1){
        return emptyList()
    }

    val result = mutableListOf(mutableListOf(1))

    repeat(numRows - 1) {
        val lastGenerate = result.last()
        val nextGenerate = mutableListOf(1)

        lastGenerate.forEachIndexed { index, it ->
            nextGenerate += lastGenerate.getOrElse(index - 1) { return@forEachIndexed } + it
        }

        nextGenerate += 1

        result += nextGenerate
    }

    return result
}