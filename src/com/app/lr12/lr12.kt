package com.app.lr12

import com.app.common.genInt
import java.io.File

class Node<T>(val value: T, var next: Node<T>?)
operator fun Number.compareTo(other: Number) = this.toDouble().compareTo(other.toDouble())

open class LinkedList<T>(var root: Node<T>?){
    fun append(value: T){
        if (root == null) {
            root = Node(value, null)
        } else {
            var ptr = root!!
            while (ptr.next != null) {
                ptr = ptr.next!!
            }
            ptr.next = Node(value, null)
        }
    }

    override fun toString(): String{
        var s = ""
        if (root == null){
            return s
        }
        var ptr = root!!
        while (ptr.next != null){
            s += "${ptr.value} "
            ptr = ptr.next!!
        }
        s += "${ptr.value} "
        return s
    }

    fun remove(node: Node<T>){
        if (root == null)
            return

        if (node == root){
            root = node.next
        } else {
            var ptr = root!!
            while (ptr.next != node)
                ptr = ptr.next!!
            ptr.next = node.next
        }
    }
}

class NumberLinkedList(root: Node<Number>?) : LinkedList<Number>(root){
    fun maxOrNull(): Number?{
        if (root == null) {
            return null
        } else {
            var ptr = root!!
            var currMax = ptr.value
            while (ptr.next != null){
                ptr = ptr.next!!
                currMax = if (ptr.value >= currMax ) ptr.value else currMax
            }
            return currMax
        }
    }

    fun minOrNull(): Number?{
        if (root == null) {
            return null
        } else {
            var ptr = root!!
            var currMin = ptr.value
            while (ptr.next != null){
                ptr = ptr.next!!
                currMin = if (ptr.value < currMin) ptr.value else currMin
            }
            return currMin
        }
    }
}

fun a1(){
    val lst = NumberLinkedList(null)
    for (i in 1..10){
        val n = genInt(0, 10)
        lst.append(n)
    }
    println(lst.toString())
    println(lst.minOrNull())
    println(lst.maxOrNull())
}

fun hasQ(n: Number): Boolean{
    return n.toString().toIntOrNull() != null && n.toInt() % 2 == 0
}

fun hasT(n: Number): Boolean{
    val s = n.toString()
    return s.contains('3') && s.contains('2')
}

fun b1(){
    val numbers = File("./assets/numbers.txt").readText().split(' ').map{it.toInt()}
    if (numbers.isEmpty())
        return
    val lst = NumberLinkedList(null)
    for (n in numbers)
        lst.append(n)
    println(lst.toString())
    var counterQ = 0

    var ptr = lst.root!!

    while (ptr.next != null){
        if (hasQ(ptr.value))
            counterQ += 1
        if (hasT(ptr.value))
            lst.remove(ptr)
        ptr = ptr.next!!
    }
    if (hasQ(ptr.value))
        counterQ += 1
    if (hasT(ptr.value))
        lst.remove(ptr)
    println(lst.toString())
    print("Количество элементов со свойством Q: $counterQ")

}