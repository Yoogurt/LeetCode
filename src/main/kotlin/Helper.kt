import java.util.*

fun IntArray.swap(index1: Int, index2: Int) {
    if (index1 == index2){
        return
    }
    
    this[index1] = this[index1] xor this[index2]
    this[index2] = this[index1] xor this[index2]
    this[index1] = this[index1] xor this[index2]
}

fun main() {
    print(Arrays.toString(intArrayOf(2, 3).also {
        it.swap(0, 1)
    }))
}