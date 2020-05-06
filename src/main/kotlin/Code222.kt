fun main(args: Array<String>) {
    println(isHappy(4))
}

private fun isHappy(n: Int): Boolean {
    var n = n
    val set = hashSetOf<Int>()

    while (!set.contains(n) && n != 1) {
        set += n

        var num = n
        n = 0
        while (num > 0) {
            n += (num % 10) * (num % 10)
            num /= 10
        }
    }

    return n == 1
}