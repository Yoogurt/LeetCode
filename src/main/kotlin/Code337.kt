fun main() {
    println(rob(buildTreeNode(1, 2, 3, 4, 5, 6, 7)))
    println(rob(buildTreeNode(1, 100, 2, 3, 200, 6, 7)))
    println(rob(buildTreeNode(3, 2, 3, null, 3, null, 1)))
    println(rob(buildTreeNode(3, 4, 5, 1, 3, null, 1)))
}

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
示例 1:
输入: [3,2,3,null,3,null,1]
3
/ \
2   3
\   \
3   1
输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

示例 2:
输入: [3,4,5,1,3,null,1]
3
/ \
4   5
/ \   \
1   3   1
输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
private fun rob(root: TreeNode?): Int {
    root ?: return 0
    return rob(root, false)
}

private fun donotRobIt(node: TreeNode, left: TreeNode?, right: TreeNode?): Int {
    val leftRob = run {
        rob(left ?: return@run 0, false)
    }

    val rightRob = run {
        rob(right ?: return@run 0, false)
    }

    return leftRob + rightRob
}

private fun robIt(node: TreeNode, left: TreeNode?, right: TreeNode?): Int {
    val robResult = node.`val`

    val leftRob = run {
        rob(left ?: return@run 0, true)
    }

    val rightRob = run {
        rob(right ?: return@run 0, true)
    }

    return robResult + leftRob + rightRob
}

private fun rob(node: TreeNode, parentIsRob: Boolean): Int {
    val left = node.left
    val right = node.right

    return if (parentIsRob) {
        donotRobIt(node, left, right)
    } else {
        kotlin.math.max(
            donotRobIt(node, left, right),
            robIt(node, left, right)
        )
    }
}