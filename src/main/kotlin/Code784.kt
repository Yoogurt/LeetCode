fun main() {
    println(letterCasePermutation("a23fD"))
    println(letterCasePermutation("C"))
}

//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
// 
//
//示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
//
private fun letterCasePermutation(s: String): List<String> {
    if (s.isEmpty()) return emptyList()

    val result = mutableListOf<String>()
    letterCasePermutation(s.toCharArray(), "", 0, result)
    return result
}

private fun letterCasePermutation(s: CharArray, current: String, index: Int, result: MutableList<String>) {
    if (index >= s.size) {
        result += current
        return
    }

    val char = s[index]

    val replaceChar = when {
        char in 'a'..'z' -> 'A' + (char - 'a')
        char in 'A'..'Z' -> 'a' + (char - 'A')
        else -> null
    }
    if (replaceChar != null)
        letterCasePermutation(s, current + replaceChar, index + 1, result)
    letterCasePermutation(s, current + char, index + 1, result)
}