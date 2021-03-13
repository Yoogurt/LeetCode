fun main() {
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1) , 0))
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1) , 2))
}

private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var n = n

    flowerbed.forEachIndexed { index, it ->
        if (it == 1) {
            return@forEachIndexed
        }

        if (n > 0 && flowerbed.getOrNull(index - 1) != 1 && flowerbed.getOrNull(index + 1) != 1) {
            flowerbed[index] = 1
            n -= 1
        }
    }

    return n == 0
}