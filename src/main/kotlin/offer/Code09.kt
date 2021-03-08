package offer

import java.util.*

private class CQueue {
    private val mStack1 = Stack<Int>()
    private val mStack2 = Stack<Int>()

    fun appendTail(value: Int) {
        mStack2.push(value)
    }

    fun deleteHead(): Int {
        if (mStack1.isEmpty()){
            while (mStack2.isNotEmpty()){
                mStack1.push(mStack2.pop())
            }
        }

        return if (mStack1.isNotEmpty()) {
            mStack1.pop()
        }else{
            -1
        }
    }
}

fun main(){
    val cQueue = CQueue()
    cQueue.appendTail(3)
    cQueue.appendTail(4)
    cQueue.appendTail(5)
    println(cQueue.deleteHead())
    println(cQueue.deleteHead())
    println(cQueue.deleteHead())
}