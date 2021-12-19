package com.app.lr2

import com.app.common.*

fun a1(A: Int, B: Int, n: Int){
    val rectangePoints = arrayOf(arrayOf(-9, -10), arrayOf(-9, 2), arrayOf(2, 2), arrayOf(2, -10))
    val xs = Array(rectangePoints.size){rectangePoints[it][0]}
    val ys = Array(rectangePoints.size){rectangePoints[it][1]}
    val minX = xs.minOrNull()!!
    val maxX = xs.maxOrNull()!!
    val minY = ys.minOrNull()!!
    val maxY = ys.maxOrNull()!!

    val points = computeF(A, B, n)
    printTable(points)
    var counter = 0
    for ((x, y) in points){
        if ((x >= minX) && (x <= maxX) && (y >= minY) && (y <= maxY)){
            counter += 1
        }
    }
    println("Внутри прямоугольника с координатами ${rectangePoints.contentDeepToString()} лежит $counter точек.")
}

fun triangleSquare(A: Array<Float>, B: Array<Float>, C: Array<Float>): Float{
    return (A[0]*(B[1] - C[1]) + B[0]*(C[1] - A[1]) + C[0]*(A[1] - B[1])) / 2
}

fun checkPointInTriangle(P:Array<Float>, A: Array<Float>, B: Array<Float>, C: Array<Float>): Boolean{
    return triangleSquare(P, A, B) + triangleSquare(P, B, C) + triangleSquare(P, A, C) == triangleSquare(A, B, C)
}

fun b1(A: Int, B: Int, n: Int){
    val points = computeF(A, B, n)
    printTable(points)
    val triangle1 = arrayOf(arrayOf(-1F, 1F), arrayOf(1F, 1F), arrayOf(0F, 0F))
    val triangle2 = arrayOf(arrayOf(-1F, -1F), arrayOf(1F, -1F), arrayOf(0F, 0F))
    var counter = 0
    for ((x, y) in points){
        val P = arrayOf(x, y)
        if (checkPointInTriangle(P, triangle1[0], triangle1[1], triangle1[2]) ||
            checkPointInTriangle(P, triangle2[0], triangle2[1], triangle2[2])){
            counter += 1
        }
    }
    println("Внутри фигуры лежит $counter точек.")

}

fun isAboveSlope(P: Array<Float>, X: Array<Float>, Y: Array<Float>): Boolean{
    val A = X[1] - Y[1]
    val B = Y[0] - X[0]
    val C = X[0] * Y[1] - Y[0] * X[1]
    return (A * P[0] + B * P[1] + C) / B > 0
}



fun c(A: Int, B: Int, n: Int){
    val points = computeF(A, B, n)
    printTable(points)

    val p1 = arrayOf(genFloat(0F, 10F), genFloat(0F, 10F))
    val p2 = arrayOf(genFloat(-10F, 0F), genFloat(0F, 10F))
    val p3 = arrayOf(genFloat(-10F, 0F), genFloat(-10F, 0F))
    val p4 = arrayOf(genFloat(0F, 10F), genFloat(-10F, 0F))
    val zero = arrayOf(0F, 0F)

    var counter = 0
    for ((x, y) in points){
        val p = arrayOf(x, y)

        if ((isAboveSlope(p, p1, p2) == isAboveSlope(zero, p1, p2)) &&
                (isAboveSlope(p, p2, p3) == isAboveSlope(zero, p2, p3)) &&
                (isAboveSlope(p, p3, p4) == isAboveSlope(zero, p3, p4)) &&
                (isAboveSlope(p, p4, p1) == isAboveSlope(zero, p4, p1))){
            counter += 1
        }
    }
    println("Внутри фигуры с координатами " +
            "${p1.contentToString()} ${p2.contentToString()} " +
            "${p3.contentToString()} ${p4.contentToString()} " +
            "лежит $counter точек.")

}
