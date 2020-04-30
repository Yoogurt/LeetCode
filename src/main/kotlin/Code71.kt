import java.util.*

fun main(args: Array<String>) {
    println(simplifyPath("/../home/"))
}

private fun simplifyPath(path: String): String {
    val result = Stack<String>()

    val path = path.split("/")

    path.forEach {
        when (it) {
            "", "." -> {

            }

            ".." -> {
                if (result.isNotEmpty()) {
                    result.pop()
                }
            }

            else -> {
                result.push(it)
            }
        }
    }

    return "/" + result.joinToString("/")
}