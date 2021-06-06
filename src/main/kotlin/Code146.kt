private class LRUCache(private val capacity: Int) {
    private val mData = hashMapOf<Int, Int>()
    private val mLru = arrayListOf<Int>()

    fun get(key: Int): Int {
        val removed = mLru.remove(key)
        if (!removed) return -1
        mLru.add(key)
        return mData[key]!!
    }

    fun put(key: Int, value: Int) {
        mLru.remove(key)

        if (mLru.size >= capacity) {
            mData.remove(mLru.removeAt(0))
        }

        mLru.add(key)
        mData[key] = value
    }
}

fun main() {
    val lruCache = LRUCache(3)
    lruCache.put(1, 100)
    lruCache.put(2, 200)
    lruCache.put(3, 300)
    lruCache.put(4, 400)
    println(lruCache.get(1))
    println(lruCache.get(2))
    println(lruCache.get(3))
}