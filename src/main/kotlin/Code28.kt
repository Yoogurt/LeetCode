fun main(args: Array<String>) {
    println(kmp("123111", ""))
}

private fun getNext(string: String): IntArray {
    var index = -1
    var scanIndex = 0

    val result = IntArray(string.length)
    result[0] = -1

    while (scanIndex < string.length - 1) {
        if (index == -1 || string[index] == string[scanIndex]) {
            index++
            scanIndex++
            result[scanIndex] = index
        } else {
            index = result[index]
        }
    }

    return result
}

fun kmp(string: String, target: String): Int {
    if (target.isEmpty()) {
        return 0
    }

    val next = getNext(target)

    var scanIndex = 0
    var index = 0

    while (scanIndex < string.length && index < target.length) {
        if (index == -1 || string[scanIndex] == target[index]) {
            scanIndex++
            index++
        } else {
            index = next[index]
        }
    }

    return if (index == target.length) {
        scanIndex - index
    } else {
        -1
    }
}