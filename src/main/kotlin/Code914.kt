fun main() {
    println(hasGroupsSizeX(intArrayOf(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3)))
}

private fun hasGroupsSizeX(deck: IntArray): Boolean {
    if (deck.isEmpty()) {
        return false
    }

    val result = mutableMapOf<Int, Int>()

    deck.forEach {
        result[it] = (result[it] ?: 0) + 1
    }

    var lastGCD: Int? = null
    return result.all {
        if (lastGCD == null) {
            lastGCD = it.value
            it.value > 1
        } else {
            lastGCD = gcd(lastGCD!!, it.value)
            lastGCD!! > 1
        }
    }
}

private fun gcd(num1: Int, num2: Int): Int {
    var num1 = num1
    var num2 = num2

    while (num1 != 0 && num2 != 0) {
        if (num1 > num2) {
            num1 %= num2
        } else {
            num2 %= num1
        }
    }

    return if (num1 == 0) {
        num2
    } else {
        num1
    }
}