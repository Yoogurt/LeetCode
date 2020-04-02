import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    println(lengthOfLongestSubstring("tmmzuxqtt"))
}

private fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0

    val mapOfIndex = TreeMap<Char , Int>()
    val chars = s.toCharArray()

    var index = 0

    chars.forEachIndexed { indexed, it ->

        val indexOfRepeat = mapOfIndex[it]
        if (indexOfRepeat != null) {
            (index until indexOfRepeat).forEach {
                mapOfIndex.remove(chars[it])
            }

            index = indexOfRepeat + 1

            mapOfIndex[it] = indexed
        } else {
            maxLength = max(maxLength , indexed - index + 1)
            mapOfIndex[it] = indexed
        }
    }

    return maxLength
}