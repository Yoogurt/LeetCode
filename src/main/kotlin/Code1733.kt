import kotlin.math.max

fun main() {
//    println(
//        minimumTeachings(
//            3, arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(1, 2)),
//            arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))
//        )
//    )

//    println(
//        minimumTeachings(
//            11,
//            arrayFromString("[[3,11,5,10,1,4,9,7,2,8,6],[5,10,6,4,8,7],[6,11,7,9],[11,10,4],[6,2,8,4,3],[9,2,8,4,6,1,5,7,3,10],[7,5,11,1,3,4],[3,4,11,10,6,2,1,7,5,8,9],[8,6,10,2,3,1,11,5],[5,11,6,4,2]]"),
//            arrayFromString("[[7,9],[3,7],[3,4],[2,9],[1,8],[5,9],[8,9],[6,9],[3,5],[4,5],[4,9],[3,6],[1,7],[1,3],[2,8],[2,6],[5,7],[4,6],[5,8],[5,6],[2,7],[4,8],[3,8],[6,8],[2,5],[1,4],[1,9],[1,6],[6,7]]")
//        )
//    )

    println(
        minimumTeachings(
            3,
            arrayFromString("[[2],[1,3],[1,2],[3]]"),
            arrayFromString("[[1,4],[1,2],[3,4],[2,3]]")
        )
    )
}

private fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
    var maxCount = 0
    var maxCommonLanguage = 0
    var cannotCommunicatePair = mutableListOf<IntArray>()

    val languagesMap = hashMapOf<Int, Int>()
    val visitedUser = hashSetOf<Int>()

    friendships.forEach {
        val aUser = it[0] - 1
        val bUser = it[1] - 1

        val aLanguages = languages[aUser].toSet()
        val bLanguages = languages[bUser]

        for (language in bLanguages) {
            if (language in aLanguages) {
                return@forEach
            }
        }

        cannotCommunicatePair += it

        if (aUser !in visitedUser) {
            aLanguages.forEach {
                languagesMap.compute(it, { key, value ->
                    val result = (value ?: 0) + 1
                    if (result > maxCount) {
                        maxCommonLanguage = key
                        maxCount = result
                    }
                    return@compute result
                })
            }
            visitedUser += aUser
        }

        if (bUser !in visitedUser) {
            bLanguages.forEach {
                languagesMap.compute(it, { key, value ->
                    val result = (value ?: 0) + 1
                    if (result > maxCount) {
                        maxCommonLanguage = key
                        maxCount = result
                    }
                    return@compute result
                })
            }

            visitedUser += bUser
        }
    }

    val visited = mutableSetOf<Int>()
    return cannotCommunicatePair.fold(0) { acc, right ->
        val aLanguages = languages[right[0] - 1].toSet()
        val bLanguages = languages[right[1] - 1].toSet()

        return@fold acc + if ((right[0] - 1) !in visited && maxCommonLanguage !in aLanguages) {
            visited += (right[0] - 1)
            1
        } else {
            0
        } + if ((right[1] - 1) !in visited && maxCommonLanguage !in bLanguages) {
            visited += ((right[1] - 1))
            1
        } else {
            0
        }
    }
}