fun main() {
    println(
        findOrder(
            4,
            arrayOf(intArrayOf(2, 1), intArrayOf(2, 0), intArrayOf(3, 0))
        ).contentToString()
    )
}

private fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val inDeg = IntArray(numCourses)
    prerequisites.forEach {
        inDeg[it[0]]++
    }

    val courses = prerequisites.toMutableSet()

    val queue = mutableListOf<Int>()
    inDeg.forEachIndexed { index, i ->
        if (i == 0) queue += index
    }

    var putIndex = 0
    val result = IntArray(numCourses)

    while (queue.isNotEmpty()) {
        val course = queue.removeAt(0)
        result[putIndex++] = course

        courses.removeAll {
            val remove = it[1] == course
            if (remove) {
                inDeg[it[0]]--
                if (inDeg[it[0]] == 0) queue += it[0]
            }
            remove
        }
    }

    return if (putIndex == numCourses) result else intArrayOf()
}