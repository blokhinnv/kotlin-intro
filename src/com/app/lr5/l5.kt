package com.app.lr5
import com.app.common.*
import kotlin.math.abs

const val A = -10
const val B = 10


fun a1(){
    val arr = createIntArray(A, B,10)
    printArray(arr)
    var firstEvenIdx = 0
    var lastOddIdx = arr.size - 1
    for (i in arr.indices){
        if (arr[i] % 2 == 0) {
            firstEvenIdx = i
            break
        }
    }
    for (i in arr.indices.reversed()){
        if (abs(arr[i]) % 2 == 1) {
            lastOddIdx = i
            break
        }
    }
    println("Сумма элементов с $firstEvenIdx по $lastOddIdx равна " +
            "${arr.slice(firstEvenIdx..lastOddIdx).sum()}")

}

fun b1(){
    val arr = createIntArray(A, B,10)
    printArray(arr)
    val topList = ArrayList<Int>()
    for (item in arr.sortedDescending()){
        if (item !in topList){
            topList.add(item)
        }
        if (topList.size == 2)
            break
    }
    print("2 различных максимума: ${topList.toString()}")
}

fun c1(){
    // TODO
}