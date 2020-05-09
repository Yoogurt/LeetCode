import kotlin.math.max

fun main(args: Array<String>) {
    println(
        longestPalindrome(
            "\"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth\""
        )
    )
}

private fun longestPalindrome(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }

    val chars = mutableMapOf<Char, Int>()

    s.forEach {
        chars[it] = (chars[it] ?: 0) + 1
    }

    return chars.values.fold(0) { left, right ->
        left + (right and 0xfffffffe.toInt())
    } + if (chars.values.any {
            (it and 1) != 0
        }) {
        1
    } else {
        0
    }
}