fun main(args: Array<String>) {
    println(isRectangleOverlap(intArrayOf(0, 0, 1, 1), intArrayOf(1, 0, 2, 1)))
}

private fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    return !(rec1[2] <= rec2[0] ||   // left
            rec1[3] <= rec2[1] ||   // bottom
            rec1[0] >= rec2[2] ||   // right
            rec1[1] >= rec2[3]);
}
