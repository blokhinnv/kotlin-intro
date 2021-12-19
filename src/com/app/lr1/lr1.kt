package com.app.lr1

import kotlin.collections.*
import com.app.common.*

fun a1(){
    val points = computeFWithConstParams()
    printTable(points)
    var negativeSum = 0.0
    var negativeCount = 0

    for ((x, f) in points){
        if (f < 0){
            negativeSum += f
            negativeCount += 1
        }
    }
    println("Среднее арифметическое всех отрицательных значений функции ${negativeSum / negativeCount}")
}

fun b1(){
    val points = computeFWithConstParams()
    printTable(points)
    var negWithOddInt = 0

    for ((x, f) in points){
//        floor(f).toInt(): -1.5 => -2
//        f.toInt(): -1.5 => -1
//        if ((f < 0) && (floor(f).toInt() % 2 != 0)){
        if ((f < 0) && (f.toInt() % 2 != 0)){
            negWithOddInt += 1
        }
    }
    println(" Количество отрицательных значений функции, имеющих нечетную\n" +
            "целую часть: $negWithOddInt")
}

fun c1() {
    val points = computeFWithConstParams()
    printTable(points)
    val nonNegValCount = mutableMapOf<Float, Int>()
    for ((x, f) in points) {
        if (f >= 0) {
            nonNegValCount[f] = nonNegValCount.getOrDefault(f, 0) + 1
        }
    }
    val minNonNegValue = nonNegValCount.keys.minOrNull()
    println("Минимальное среди неотрицательных значений функции: $minNonNegValue встретилось " +
            "${nonNegValCount[minNonNegValue]} раз.")
}
