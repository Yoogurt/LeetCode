fun main() {
}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    p ?: q ?: return true

    if (p?.`val` != q?.`val`) {
        return false
    }

    return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}