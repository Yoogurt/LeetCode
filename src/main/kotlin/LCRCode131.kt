import kotlin.math.max

fun main() {
    println(cuttingBamboo2(6))
}

private fun cuttingBamboo(bamboo_len: Int): Int {
    val result = IntArray(bamboo_len + 1) { 1 }

    result.forEachIndexed { cur, it ->
        repeat(cur) { indexed ->
            if (cur == bamboo_len && indexed == 0) return@repeat
            result[cur] = max(result[cur], result[indexed] * (cur - indexed))
        }
    }

    return result.last()
}

private fun cuttingBamboo2(bamboo_len: Int): Int {
    if (bamboo_len == 2) { return 1 }
    if (bamboo_len == 3) { return 2 }

    var result = 1
    var bamboo_len = bamboo_len

    while (bamboo_len > 4) {
        result *= 3
        bamboo_len -= 3
    }
    result *= bamboo_len

    return result
}