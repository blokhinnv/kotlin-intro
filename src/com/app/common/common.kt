package com.app.common
import kotlin.math.*

private const val A = -5.0F
private const val B = 5.0F
private const val H = 0.1F

fun computeFWithConstParams(): kotlin.collections.Map<Float, Float> {
    val nSteps = ((B - A) / H).toInt()
    val points = mutableMapOf<Float, Float>()
    val xs = Array(nSteps+1){ it * (B - A) / nSteps + A}

    for (x in xs) {
        points[x] = x * exp(x) + 2 * sin(x) - sqrt(abs(x.pow(3) - x.pow(2)))
    }
    return points.toMap()
}

fun computeF(A: Int, B: Int, n: Int): kotlin.collections.Map<Float, Float> {
    val points = mutableMapOf<Float, Float>()
    val xs = Array(n){ it  * ((B.toFloat() - A.toFloat()) / n) + A}

    for (x in xs) {
        points[x] = x * exp(x) + 2 * sin(x) - sqrt(abs(x.pow(3) - x.pow(2)))
    }
    return points.toMap()
}


fun printTable(points: Map<Float, Float>){
    val header = "|    x    |      f     |"
    println(header)
    println("-".repeat(header.length))

    for ((x, f) in points){
        println("| %+.4f | %+10.4f |".format(x, f))
    }
}

fun genFloat(min: Float, max: Float): Float{
    return min + kotlin.random.Random.nextFloat() * (max - min)
}

fun genInt(min: Int, max: Int): Int{
    return kotlin.random.Random.nextInt(min, max)
}

fun String.isInt() = this.toIntOrNull() != null

fun readInt(): Int{
    var s: String
    do {
        print("Введите число: ")
        s = readLine()!!
    } while (!s.isInt())
    return s.toInt()
}

fun createIntArray(a:Int, b:Int, n: Int): Array<Int> {
    return Array(n){ genInt(a, b) }
}

fun readIntArray(n: Int): Array<Int>{
    return Array(n){readInt()}
}


fun <T> printArray(arr: Array<T>){
    println(arr.contentToString())
}

fun findMin(arr: Array<Int>): Int{
    return arr.minOrNull()!!
}

fun findMax(arr: Array<Int>): Int{
    return arr.maxOrNull()!!
}
