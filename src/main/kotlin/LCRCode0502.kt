fun main() {
    println(printBin(0.5 + 0.5 / 4 + 0.5 / 16 + 0.5 / 128))
}

private fun printBin(num: Double): String {
    var current = 0.0
    var result = "0"
    var base = 1.0

    if (current == num) {
        return result
    }

    result = "$result."

    repeat(33) {
        val now = current + base / 2
        if (now > num) {
            result += "0"
        } else {
            result += "1"

            if (now == num) {
                return result
            }

            current = now
        }

        base /= 2
    }

    return "ERROR"
}