package com.app.lr4

import kotlin.math.max
import kotlin.math.sqrt
import kotlin.math.abs


fun a1(){
    var currentMax = 0
    while (true) {
        print("Введите число: ")
        val x = readLine()!!.toInt()
        if (x == 0){
            break
        }
        currentMax = if (currentMax != 0) max(currentMax, x) else x
    }
    println("Наибольшее введенное значение: $currentMax")
    println("Наибольшее введенное значение в обратном порядке: ${currentMax.toString().reversed()}")
}

fun b1(){
    var maxOddIdx = 0
    var maxOddValue = 0
    var minEvenIdx = 0
    var minEvenValue = 0

    var idx = 0
    while (true) {
        print("Введите число: ")
        val x = readLine()!!.toInt()
        if (x == 0){
            break
        }
        if ((x % 2 == 0) && ((minEvenValue == 0) || (x < minEvenValue))){
            minEvenValue = x
            minEvenIdx = idx
        } else if ((x % 2 == 1) && ((maxOddValue == 0) || (x > maxOddValue))){
            maxOddValue = x
            maxOddIdx = idx
        }
        idx += 1
    }
    println("Наименьшее введенное четное значение $minEvenValue имеет индекс $minEvenIdx")
    println("Наибольшее введенное нечетное значение $maxOddValue имеет индекс $maxOddIdx")

}

fun isPrime(n: Int): Boolean{
    for (i in 2..sqrt(abs(n.toFloat())).toInt()){
        if (n % i == 0)
            return false
    }
    return true
}

fun c1(){
    // TODO
}