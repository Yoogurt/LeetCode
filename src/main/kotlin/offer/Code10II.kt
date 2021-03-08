package offer

fun main() {
    println(numWays(7))
}

private fun numWays(n: Int): Int {
    if (n == 0){
        return 1
    }

    if (n < 3){
        return n
    }

    var temp = 1
    var result = 2

    repeat(n - 2){
        result = ((temp + result) % 1000000007).also {
            temp = result
        }
    }

    return result
}