fun main() {
    println(checkPowersOfThree(12))
    println(checkPowersOfThree(21))
    println(checkPowersOfThree(91))
}

private fun checkPowersOfThree(n: Int): Boolean {

    var n = n
    while (n > 0) {
        if (n % 3 == 2) {
            return false
        }
        n /= 3
    }

    return true
}