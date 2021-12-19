package com.app.lr6
import com.app.common.*

const val A = -5
const val B = 35

fun a1(){
    val arr = createIntArray(A, B, n=10)
    println("Массив до модификации: ")
    printArray(arr)
    val min = findMin(arr)
    for (idx in arr.indices){
        if (arr[idx] > 0){
            arr[idx] = min
        }
    }
    println("Массив после модификации: ")
    printArray(arr)
}

fun findMinWithQ(arr: Array<Int>): Int?{
   return arr.filter { s -> s % 2 == 0 }.minOrNull()
}

fun replaceT(arr: Array<Int>){
    for (idx in arr.indices){
        val s = arr[idx].toString()
        if (('2' in s) && ('3' in s)){
            arr[idx] = s.reversed().toInt()
        }
    }
}

fun b1(){
    val arr = createIntArray(A, B, 10)
    println("Массив до модификации: ")
    printArray(arr)
    println("Минимальный элемент массива со свойством Q: ${findMinWithQ(arr)}")
    replaceT(arr)
    println("Массив после модификации: ")
    printArray(arr)
}

fun c(){
    // TODO
}