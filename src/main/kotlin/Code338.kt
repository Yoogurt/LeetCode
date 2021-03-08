fun main() {
    println(countBits(5).contentToString())
}

private fun countBits(num: Int): IntArray {
    val result = IntArray(num + 1)

    var upper = 1
    var downer = upper ushr 1

    (1 until result.size).forEach {
        if (it >= upper){
            upper = upper shl 1
            downer = upper ushr 1
        }

        result[it] = result[it and downer.inv()] + 1
    }

    return result
}