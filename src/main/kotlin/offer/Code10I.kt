package offer

fun main() {
    println(fib(3))
}

private fun fib(n: Int): Int {
    if (n <= 0){
        return 0
    }

    if (n == 1){
        return 1
    }

    if (n == 2){
        return 1
    }

    var temp = 1
    var result = 1

    repeat(n - 2){
        result = ((temp + result) % 1000000007).also {
            temp = result
        }
    }

    return result
}