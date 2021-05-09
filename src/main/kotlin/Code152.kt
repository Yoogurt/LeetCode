fun main() {
    print(maxProduct(intArrayOf(2, 3, -2, 4)))
}

private fun maxProduct(nums: IntArray): Int {
    var maxResult = nums.first()

    var maxF = nums.first()
    var minF = nums.first()

    nums.forEachIndexed { indexed , i ->
        if(indexed < 1){
            return@forEachIndexed
        }

        val tempMax = maxF
        val tempMin = minF

        maxF = maxOf(i * tempMax, maxOf(i, tempMin * i))
        minF = minOf(i * tempMin, minOf(i, tempMax * i))

        maxResult = maxOf(maxF, maxResult)
    }

    return maxResult
}