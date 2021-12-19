package com.app.lr13

import com.app.lr12.LinkedList
import com.app.lr11.Auto
import com.app.lr11.createFile_a1
import com.app.lr12.NumberLinkedList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

fun readFileAutoAsLinkedList(fileName: String): LinkedList<Auto>{
    val lst = LinkedList<Auto>(null)

    val dataRepr = File(fileName).readBytes().toString(Charsets.UTF_8)
    val dataAsLst = dataRepr.split('\n').filter { it.isNotEmpty() }
    for (itemStr in dataAsLst){
        val itemObj: Auto = Gson().fromJson(itemStr, object : TypeToken<Auto>() {}.type)
        lst.append(itemObj)
    }
    return lst
}

fun findNewest(autos: LinkedList<Auto>): LinkedList<Auto>{
    val yearsLst = NumberLinkedList(null)
    var autoNode = autos.root!!
    var maxYear = autoNode.value.year
    while (autoNode.next != null){
        maxYear = if (autoNode.value.year > maxYear) autoNode.value.year else maxYear
        autoNode = autoNode.next!!
    }

    val newestAutoLst = LinkedList<Auto>(null)
    autoNode = autos.root!!
    while (autoNode.next != null){
        if (autoNode.value.year == maxYear)
            newestAutoLst.append((autoNode.value))
        autoNode = autoNode.next!!
    }
    return newestAutoLst
}

fun a1(){
    println("Создаем файл...")
    createFile_a1("./assets/test.bin")
    println("Читаем файл...")
    val autos = readFileAutoAsLinkedList("./assets/test.bin")
    println(autos.toString())
    val newest = findNewest(autos)
    print("Самые новые машины: ${newest.toString()}")
}

fun b1(){
    // TODO
}

fun c1(){
    // TODO
}

