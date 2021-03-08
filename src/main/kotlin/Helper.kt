fun IntArray.swap(index1: Int, index2: Int) {
    if (index1 == index2){
        return
    }
    
    this[index1] = this[index1] xor this[index2]
    this[index2] = this[index1] xor this[index2]
    this[index1] = this[index1] xor this[index2]
}