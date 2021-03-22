package everyday

fun main(){
    intArrayOf(0,1,5,0,1,3).also {
        moveZeroes(it)
        print(it)
    }
}

private fun moveZeroes(nums: IntArray) {
    var moveIndex = 0

    nums.forEach{
        if (it != 0){
            nums[moveIndex++] = it
        }
    }

    while (moveIndex < nums.size){
        nums[moveIndex++] = 0
    }
}