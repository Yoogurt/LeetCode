import java.util.*

fun main() {
    println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
    println(largestRectangleArea(intArrayOf(1, 1, 1, 1, 1, 11, 1, 1, 1, 1)))
    println(largestRectangleArea(intArrayOf()))
    println(largestRectangleArea(intArrayOf(0, 1, 100)))
}

/**
 * 我们归纳一下枚举「高」的方法：


首先我们枚举某一根柱子 iii 作为高 h=heights[i]h = \textit{heights}[i]h=heights[i]；


随后我们需要进行向左右两边扩展，使得扩展到的柱子的高度均不小于 hhh。换句话说，我们需要找到左右两侧最近的高度小于 hhh 的柱子，这样这两根柱子之间（不包括其本身）的所有柱子高度均不小于 hhh，并且就是 iii 能够扩展到的最远范围。


那么我们先来看看如何求出一根柱子的左侧且最近的小于其高度的柱子。除了根据「前言」部分暴力地进行枚举之外，我们可以通过如下的一个结论来深入地进行思考：

对于两根柱子 j0j_0j0​ 以及 j1j_1j1​，如果 j0<j1j_0 < j_1j0​<j1​ 并且 heights[j0]≥heights[j1]\textit{heights}[j_0] \geq \textit{heights}[j_1]heights[j0​]≥heights[j1​]，那么对于任意的在它们之后出现的柱子 iii（j1<ij_1 < ij1​<i），j0j_0j0​ 一定不会是 iii 左侧且最近的小于其高度的柱子。

换句话说，如果有两根柱子 j0j_0j0​ 和 j1j_1j1​，其中 j0j_0j0​ 在 j1j_1j1​ 的左侧，并且 j0j_0j0​ 的高度大于等于 j1j_1j1​，那么在后面的柱子 iii 向左找小于其高度的柱子时，j1j_1j1​ 会「挡住」j0j_0j0​，j0j_0j0​ 就不会作为答案了。
这样以来，我们可以对数组从左向右进行遍历，同时维护一个「可能作为答案」的数据结构，其中按照从小到大的顺序存放了一些 jjj 值。根据上面的结论，如果我们存放了 j0,j1,⋯ ,jsj_0, j_1, \cdots, j_sj0​,j1​,⋯,js​，那么一定有 height[j0]<height[j1]<⋯<height[js]\textit{height}[j_0] < \textit{height}[j_1] < \cdots < \textit{height}[j_s]height[j0​]<height[j1​]<⋯<height[js​]，因为如果有两个相邻的 jjj 值对应的高度不满足 <<< 关系，那么后者会「挡住」前者，前者就不可能作为答案了。
当我们枚举到第 iii 根柱子时，我们的数据结构中存放了 j0,j1,⋯ ,jsj_0, j_1, \cdots, j_sj0​,j1​,⋯,js​，如果第 iii 根柱子左侧且最近的小于其高度的柱子为 jij_iji​，那么必然有
height[j0]<height[j1]<⋯<height[ji]<height[i]≤height[ji+1]<⋯<height[js]\textit{height}[j_0] < \textit{height}[j_1] < \cdots < \textit{height}[j_i] < \textit{height}[i] \leq \textit{height}[j_{i+1}] < \cdots < \textit{height}[j_s]
height[j0​]<height[j1​]<⋯<height[ji​]<height[i]≤height[ji+1​]<⋯<height[js​]
这样我们就可以使用二分查找的方法找到 iii 对应的 jij_iji​，但真的需要吗？当我们枚举到 i+1i+1i+1 时，原来的 iii 也变成了 jjj 值，因此 iii 会被放入数据结构。由于所有在数据结构中的 jjj 值均小于 iii，那么所有高度大于等于 height[i]\textit{height}[i]height[i] 的 jjj 都不会作为答案，需要从数据结构中移除。而我们发现，这些被移除的 jjj 值恰好就是
ji+1,⋯ ,jsj_{i+1}, \cdots, j_s
ji+1​,⋯,js​
这样我们在枚举到第 iii 根柱子的时候，就可以先把所有高度大于等于 height[i]\textit{height}[i]height[i] 的 jjj 值全部移除，剩下的 jjj 值中高度最高的即为答案。在这之后，我们将 iii 放入数据结构中，开始接下来的枚举。此时，我们需要使用的数据结构也就呼之欲出了，它就是栈。


栈中存放了 jjj 值。从栈底到栈顶，jjj 的值严格单调递增，同时对应的高度值也严格单调递增；


当我们枚举到第 iii 根柱子时，我们从栈顶不断地移除 height[j]≥height[i]\textit{height}[j] \geq \textit{height}[i]height[j]≥height[i] 的 jjj 值。在移除完毕后，栈顶的 jjj 值就一定满足 height[j]<height[i]\textit{height}[j] < \textit{height}[i]height[j]<height[i]，此时 jjj 就是 iii 左侧且最近的小于其高度的柱子。

这里会有一种特殊情况。如果我们移除了栈中所有的 jjj 值，那就说明 iii 左侧所有柱子的高度都大于 height[i]\textit{height}[i]height[i]，那么我们可以认为 iii 左侧且最近的小于其高度的柱子在位置 j=−1j=-1j=−1，它是一根「虚拟」的、高度无限低的柱子。这样的定义不会对我们的答案产生任何的影响，我们也称这根「虚拟」的柱子为「哨兵」。



我们再将 iii 放入栈顶。


栈中存放的元素具有单调性，这就是经典的数据结构「单调栈」了。
例子
我们用一个具体的例子 [6,7,5,2,4,5,9,3][6, 7, 5, 2, 4, 5, 9, 3][6,7,5,2,4,5,9,3] 来帮助读者理解单调栈。我们需要求出每一根柱子的左侧且最近的小于其高度的柱子。初始时的栈为空。


我们枚举 666，因为栈为空，所以 666 左侧的柱子是「哨兵」，位置为 -1。随后我们将 666 入栈。

栈：[6(0)]。（这里括号内的数字表示柱子在原数组中的位置）



我们枚举 777，由于 6<76<76<7，因此不会移除栈顶元素，所以 777 左侧的柱子是 666，位置为 000。随后我们将 777 入栈。

栈：[6(0), 7(1)]



我们枚举 555，由于 7≥57\geq 57≥5，因此移除栈顶元素 777。同样地，6≥56 \geq 56≥5，再移除栈顶元素 666。此时栈为空，所以 555 左侧的柱子是「哨兵」，位置为 −1-1−1。随后我们将 555 入栈。

栈：[5(2)]



接下来的枚举过程也大同小异。我们枚举 222，移除栈顶元素 555，得到 222 左侧的柱子是「哨兵」，位置为 −1-1−1。将 222 入栈。

栈：[2(3)]



我们枚举 444，555 和 999，都不会移除任何栈顶元素，得到它们左侧的柱子分别是 222，444 和 555，位置分别为 333，444 和 555。将它们入栈。

栈：[2(3), 4(4), 5(5), 9(6)]



我们枚举 333，依次移除栈顶元素 999，555 和 444，得到 333 左侧的柱子是 222，位置为 333。将 333 入栈。

栈：[2(3), 3(7)]



这样以来，我们得到它们左侧的柱子编号分别为 [−1,0,−1,−1,3,4,5,3][-1, 0, -1, -1, 3, 4, 5, 3][−1,0,−1,−1,3,4,5,3]。用相同的方法，我们从右向左进行遍历，也可以得到它们右侧的柱子编号分别为 [2,2,3,8,7,7,7,8][2, 2, 3, 8, 7, 7, 7, 8][2,2,3,8,7,7,7,8]，这里我们将位置 888 看作「哨兵」。
在得到了左右两侧的柱子之后，我们就可以计算出每根柱子对应的左右边界，并求出答案了。
 */

private fun Stack<Int>.bottomOrNotFound(): Int =
    if (isEmpty()) {
        -1
    } else {
        last()
    }

private fun largestRectangleArea(heights: IntArray): Int {
    if (heights.isEmpty()) {
        return 0
    }

    val elementLeftIndex = IntArray(heights.size) { -1 }
    val elementRightIndex = IntArray(heights.size) { heights.size }

    val stack = Stack<Int>()

    heights.forEachIndexed { index, height ->
        if (stack.isEmpty()) {
            stack.push(index)
            return@forEachIndexed
        }

        while (stack.isNotEmpty() && heights[stack.peek()] > height) {
            val popIndex = stack.pop()
            elementRightIndex[popIndex] = index
        }

        elementLeftIndex[index] = stack.bottomOrNotFound()
        stack.push(index)
    }

    var result = 0

    elementLeftIndex.indices.forEach {
        result = kotlin.math.max(result, (elementRightIndex[it] - elementLeftIndex[it] - 1) * heights[it])
    }

    return result
}