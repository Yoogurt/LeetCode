fun main(){
    println(getRow(0))
}

private fun getRow(rowIndex: Int): List<Int> {
    if (rowIndex < 0){
        return emptyList()
    }

    var result = mutableListOf(1)

    repeat(rowIndex) {
        val lastGenerate = result
        val nextGenerate = mutableListOf(1)

        lastGenerate.forEachIndexed { index, it ->
            nextGenerate += lastGenerate.getOrElse(index - 1) { return@forEachIndexed } + it
        }

        nextGenerate += 1

        result = nextGenerate
    }

    return result
}