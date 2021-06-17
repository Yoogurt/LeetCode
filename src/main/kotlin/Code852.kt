fun main() {
    println(peakIndexInMountainArray(intArrayOf(100 , 99 , 98)))
}

private fun peakIndexInMountainArray(arr: IntArray): Int {
    var start = 0
    var end = arr.lastIndex

    while (start < end) {
        val middle = (start + end) ushr 1

        val biggerThanPre = biggerThan(arr, middle, middle - 1)
        val biggerThanAfter = biggerThan(arr, middle, middle + 1)

        when {
            biggerThanPre && biggerThanAfter -> return middle
            biggerThanPre -> start = middle + 1
            else -> end = middle - 1
        }
    }

    return start
}

private fun biggerThan(data: IntArray, compare: Int, to: Int): Boolean {
    if (to !in data.indices || compare !in data.indices) return true

    return data[compare] > data[to]
}