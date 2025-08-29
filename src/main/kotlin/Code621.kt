import kotlin.math.max

fun main() {
    println(leastInterval(charArrayOf( 'A', 'A', 'A', 'A', 'G'), 1))
}

private fun leastInterval(tasks: CharArray, n: Int): Int {
    if (n <= 0) {
        return tasks.size
    }

    val data = linkedMapOf<Char, Int>()
    var max = 0
    var maxCount = 0
    tasks.forEach {
        val times = (data[it] ?: 0) + 1
        data[it] = times

        if (times > max) {
            max = times
            maxCount = 1
        } else if (times == max) {
            maxCount++
        }
    }

    return max(maxCount + (max - 1) * (n + 1), tasks.size)
}