import java.util.*

fun main() {
    println(simplifyPath("/home//foo/"))
    println(simplifyPath("/a/./b/../../../c/"))
}

private fun simplifyPath(path: String): String {
    val stack = Stack<String>()

    path.split("/").forEach {
        when (it) {
            ".." -> {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
            }

            "." -> {

            }

            "" -> {

            }

            else -> {
                stack.push(it)
            }
        }
    }

    return "/" + stack.joinToString(separator = "/")
}