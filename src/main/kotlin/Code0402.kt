fun main(args: Array<String>) {
    println(sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9)))
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) {
        return null
    }

    val middle = nums.size ushr 1

    val root = TreeNode(nums[middle])

    root.left = sortedArrayToBST(nums.copyOfRange(0, middle))
    root.right = sortedArrayToBST(nums.copyOfRange(middle + 1, nums.size))

    return root
}