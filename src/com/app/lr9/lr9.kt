package com.app.lr9

import com.app.common.createIntArray
import com.app.common.printArray

fun a1Recursive(arr: List<Int>): Int{
    if (arr.isEmpty()){
        return 0
    }
    return (1 - arr[0] % 2) + a1Recursive(arr.slice(1 until arr.size))
}

fun a1Iter(arr: Array<Int>): Int{
    return arr.map { 1 - it % 2 }.sum()
}

fun a1(){
    val arr = createIntArray(0, 20, 5)
    printArray(arr)
    println("Количество четных элементов (вычислено рекурсивно): ${a1Recursive(arr.toList())}")
    println("Количество четных элементов (вычислено итеративно): ${a1Iter(arr)}")
}

fun hasQ(n: Int): Boolean{
    return n % 2 == 0
}

fun hasT(n: Int): Boolean{
    val s = n.toString()
    return s.contains('3') && s.contains('2')
}

fun countWithQRecursive(arr: List<Int>): Int{
    if (arr.size == 1){
        return if (hasQ(arr.first())) 1 else 0
    }
    val splitIdx = (arr.size / 2).toInt()
    return countWithQRecursive(arr.slice(0 until splitIdx)) + countWithQRecursive(arr.slice(splitIdx until arr.size ))
}

fun sumWithTRecursice(arr: List<Int>): Int{
    if (arr.size == 1){
        val item = arr.first()
        return if (hasT(item)) item else 0
    }
    val splitIdx = (arr.size / 2).toInt()
    return sumWithTRecursice(arr.slice(0 until splitIdx)) + sumWithTRecursice(arr.slice(splitIdx until arr.size ))
}

fun sumWithTIter(arr: Array<Int>): Int{
    return arr.filter { hasT((it)) }.sum()
}

fun anyHasQRecursive(arr: List<Int>): Boolean{
    if (arr.size == 1){
        return hasQ(arr.first())
    }
    val splitIdx = (arr.size / 2).toInt()
    return anyHasQRecursive(arr.slice(0 until splitIdx)) || anyHasQRecursive(arr.slice(splitIdx until arr.size ))
}

fun anyHasQIterative(arr: Array<Int>): Boolean{
    return arr.any() { hasQ(it) }
}

fun allHaveTRecursive(arr: List<Int>): Boolean{
    if (arr.size == 1){
        return hasT(arr.first())
    }
    val splitIdx = (arr.size / 2).toInt()
    return allHaveTRecursive(arr.slice(0 until splitIdx)) && allHaveTRecursive(arr.slice(splitIdx until arr.size ))
}

fun allHaveTIterative(arr: Array<Int>): Boolean{
    return arr.all() { hasT(it) }
}


fun b1(){
    val arr = createIntArray(20, 26, 10)
    val lst = arr.toList()
    printArray(arr)
    println("Количество элементов, обладающих свойством Q (рекурсивно): ${countWithQRecursive(lst)}")
    println("Количество элементов, обладающих свойством Q (итеративно): ${a1Iter(arr)}")
    println("Сумма элементов, обладающих свойством T (рекурсивно): ${sumWithTRecursice(lst)}")
    println("Сумма элементов, обладающих свойством T (итеративно): ${sumWithTIter(arr)}")
    println("Обладает ли хотя бы один элемент свойством Q (рекурсивно): ${anyHasQRecursive(lst)}")
    println("Обладает ли хотя бы один элемент свойством Q (итеративно): ${anyHasQIterative(arr)}")
    println("Обладают ли все элементы свойством T (рекурсивно): ${allHaveTRecursive(lst)}")
    println("Обладают ли все элементы свойством T (итеративно): ${allHaveTIterative(arr)}")

}

fun c1(){
    // TODO
}
