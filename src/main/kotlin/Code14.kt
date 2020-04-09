import kotlin.math.min

fun main(args: Array<String>) {
    println(longestCommonPrefix(arrayOf("flower", "flo", "floght")))
}

private fun longestCommonPrefix(strs: Array<String>): String {
    if(strs.isEmpty()){
        return ""
    }

    var scanIndex = 0

    var commonScanIndex = Int.MAX_VALUE

    while (scanIndex < strs.size) {
        commonScanIndex = if (scanIndex + 1 <= strs.lastIndex) {
            val firstString = strs[scanIndex]
            val secondString = strs[scanIndex + 1]

            min(commonScanIndex, longestCommonPrefix(firstString, secondString, min(commonScanIndex, min(firstString.length, secondString.length))))
        } else {
            min(commonScanIndex, strs[scanIndex].length)
        }
        scanIndex += 2
    }

    scanIndex = 1

    while (scanIndex < strs.size) {
        commonScanIndex = if (scanIndex + 1 <= strs.lastIndex) {
            val firstString = strs[scanIndex]
            val secondString = strs[scanIndex + 1]

            min(commonScanIndex, longestCommonPrefix(firstString, secondString, min(commonScanIndex, min(firstString.length, secondString.length))))
        } else {
            min(commonScanIndex, strs[scanIndex].length)
        }
        scanIndex += 2
    }

    return strs.first().substring(0 until commonScanIndex)
}

private fun longestCommonPrefix(string1: String, string2: String, until: Int): Int {

    var scanIndex = 0

    while (scanIndex < until) {
        if (string1[scanIndex] != string2[scanIndex]) {
            break
        }
        scanIndex++
    }
    return scanIndex
}