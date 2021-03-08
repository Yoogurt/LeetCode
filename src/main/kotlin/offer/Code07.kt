package offer

import TreeNode
import kotlin.jvm.internal.Ref

fun main() {
    println(buildTree(intArrayOf(4,2,1,3,5), intArrayOf(1,2,3,4,5)))
}

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    return rebuildTree(preorder, Ref.IntRef(), inorder)
}

//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
private fun rebuildTree(
    preorder: IntArray,
    preorderIndex: Ref.IntRef,
    inorder: IntArray
): TreeNode? {
    val value = preorder.getOrNull(preorderIndex.element) ?: return null

    val indexInInOrder = inorder.indexOf(value)
    if (indexInInOrder < 0) {
        return null
    }

    preorderIndex.element++

    val treeNode = TreeNode(value)

    treeNode.left = rebuildTree(preorder, preorderIndex, inorder.copyOfRange(0, indexInInOrder))
    treeNode.right = rebuildTree(preorder, preorderIndex, inorder.copyOfRange(indexInInOrder + 1, inorder.size))

    return treeNode
}