package com.app.lr3
import kotlin.math.pow


fun a1(n: Int){
//    это функция sum
    val series = Array(n) {1.0 / ((it + 1) * (it + 1) + 10)}
    println("Сумма $n членов ряда равна ${series.sum()}")
}

fun a_n(n: Int): Double{
    return (n.toDouble() + 1) / (n.toDouble().pow(3) + 1)
}

fun b1_1(n: Int){
//    sum1
    val series = Array(n) {(-1.0).pow(it+1) * (it+2) / ((it+1.0).pow(3)+1)}
    println("Сумма $n членов ряда равна ${series.sum()}")

}

fun b1_2(eps: Double){
//    sum2
//    S = S_n + R_n
//    |R_n| <= a_(n+1)
    var idx = 1
    while (a_n(idx+1) > eps){
        idx += 1
    }
    val series = Array(idx){(-1.0).pow(it+1) * (it+2) / ((it+1.0).pow(3)+1)}
    println("Сумма членов ряда с точностью до $eps равна ${series.sum()}")
}

