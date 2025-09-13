import com.google.gson.Gson

val gson = Gson()

inline fun <reified T> arrayFromString(content: String): T {
    return gson.fromJson(content, T::class.java)
}