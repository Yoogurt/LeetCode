import java.lang.ref.WeakReference

typealias ReceiverZone<T> = (T.() -> Unit) -> Unit

inline fun <T> weak(self: T, action: (ReceiverZone<T>) -> Unit) {
    val weakReference = WeakReference(self)

    action {
        weakReference.get()?.also(it)
    }
}

fun main() {
    val set = hashSetOf<Int>()
    set.iterator().next()
}