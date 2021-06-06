fun main() {
    println(romanToInt("MCMXCIV"))
    println(romanToInt("IV"))
    println(romanToInt("IX"))
    println(romanToInt("LVIII"))
}

private fun romanToInt(s: String): Int {
    var result = 0

    var index = 0
    while (index < s.length) {
        val char = s[index]

        when (char) {
            'I' -> {
                when (s.getOrNull(index + 1)) {
                    'V' -> {
                        result += 4
                        index++
                    }
                    'X' -> {
                        result += 9
                        index++
                    }
                    else -> {
                        result += 1
                    }
                }
            }
            'V' -> result += 5
            'X' -> {
                when (s.getOrNull(index + 1)) {
                    'L' -> {
                        result += 40
                        index++
                    }
                    'C' -> {
                        result += 90
                        index++
                    }
                    else -> {
                        result += 10
                    }
                }
            }
            'L' -> result += 50
            'C' -> {
                when (s.getOrNull(index + 1)) {
                    'D' -> {
                        result += 400
                        index++
                    }
                    'M' -> {
                        result += 900
                        index++
                    }
                    else -> {
                        result += 100
                    }
                }
            }
            'D' -> result += 500
            'M' -> result += 1000
        }
        index++
    }

    return result
}