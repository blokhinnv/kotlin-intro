package com.app.lr8

import com.app.common.createIntArray
import com.app.common.printArray

const val A = 2
const val B = 5

fun create2dArray(m: Int, n: Int): Array<Array<Int>>{
    return Array(m){ createIntArray(A, B, n=n)}
}

fun print2dArray(arr: Array<Array<Int>>){
    arr.forEach { printArray(it) }
}

fun a1(m:Int=5, n:Int=7){

    val a = create2dArray(m, n)
    print2dArray(a)
    var b = Array(m){0}
    for ((idx, value) in a.withIndex()){
        b[idx] = value.filter { x -> (x % 2 == 0) && (x > 0) }.sum()
    }
    printArray(b)

}

fun buildMapFrom2dArray(arr: Array<Array<Int>>): MutableMap<Int, Int>{
    return buildMap<Int, Int> {
        arr.flatten().distinct().forEach {
            put(it, 0)
        }
    }.toMutableMap()
}

fun b1(m:Int=5, n:Int=7){

    val a = create2dArray(m, n)
    print2dArray(a)
    val countByRow = buildMapFrom2dArray(a)
    val countByCol = buildMapFrom2dArray(a)

    for (row in a){
        for (item in row.distinct())
            countByRow[item] = countByRow[item]!! + 1
    }

    for (col_idx in 0 until n){
        for (item in  Array(m) { a[it][col_idx] } .distinct()){
            countByCol[item] = countByCol[item]!! + 1
        }
    }
    println(countByRow)
    println(countByCol)

    for (item in countByRow.keys){
        if ((countByRow[item] == m) && (countByCol[item] == n)){
            println("$item входит во все строки и столбцы")
        }
    }
}
fun c1(){
    // TODO
}