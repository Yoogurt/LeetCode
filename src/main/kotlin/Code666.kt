fun main() {
    println(pathSum(intArrayOf(113, 229, 349, 470, 485)))
}

private fun pathSum(nums: IntArray): Int {
    var layer = IntArray(16) { 0 }
    var currentLayer = IntArray(16) { 0 }
    var currentDepth = 1

    var result = 0

    nums.forEach {
        val depth = it / 100
        val position = (it / 10) % 10
        val weight = it % 10

        if (currentDepth != depth) {
            currentDepth = depth
            layer = currentLayer
            currentLayer = IntArray(16) { 0 }
        }

        result += weight
        val parentIndex = (position + 1) ushr 1
        if (layer[parentIndex] < 0) {
            currentLayer[position] = weight - layer[parentIndex]
            result += -layer[parentIndex]
        } else {
            currentLayer[position] = weight + layer[parentIndex]
            layer[parentIndex] = -layer[parentIndex]
        }
    }

    return result
}