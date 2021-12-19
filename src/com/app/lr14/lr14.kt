package com.app.lr14

import java.io.File

class Node(val value: Int, val left: Node?=null, val right: Node?=null){
    fun asString(level: Int = 0): String {
        var s = "$value\n"
        if (this.left != null){
            val prefix = "\t".repeat(level)
            s += "$prefix left:${this.left.asString(level+1)}"
        }
        if (this.right != null){
            val prefix = "\t".repeat(level)
            s += "$prefix right:${this.right.asString(level+1)}"
        }
        return s
    }
}

fun makeTree(numbers: List<Int>): Node{
    if (numbers.size == 1){
        return Node(numbers.first())
    } else if (numbers.size == 2){
        return Node(numbers.last(), left=Node(numbers.first()))
    } else{
        val rootIdx = (numbers.size / 2).toInt()
        return Node(value=numbers[rootIdx],
                    left=makeTree(numbers.slice(0 until rootIdx)),
                    right= makeTree(numbers.slice(rootIdx+1 until numbers.size)))
    }
}

fun a1(){
    val numbers = File("./assets/numbers.txt").readText().split(' ').map{ it.toInt()}.sorted()
    println(numbers)
    val tree = makeTree(numbers)
    println(tree.asString())
}