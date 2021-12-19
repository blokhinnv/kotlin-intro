package com.app.lr10

import java.io.File
import java.util.regex.Pattern

fun a1(){
    println(System.getProperty("user.dir"))
    val wordRegex = "[а-яА-Я]+".toRegex()
    val text = File("./assets/data.txt").readText()
    val words = wordRegex.findAll(text).map{it.value}.filter { it.first().isUpperCase() && it.last().isLowerCase() }
    println(words.toList())
}

fun hasQ(s: String): Boolean{
    val signRegex= "[+\\-–*\\/^]".toRegex()
    return s.isNotEmpty() && !signRegex.containsMatchIn(s)
}

fun b1(){
    val text = File("./assets/data2.txt").readText()
    val delimiterPattern = Pattern.compile("[_.,;:\\n\\t!?]")
    val words = text.split(delimiterPattern).filter { hasQ(it) }
    val writer = File("./assets/b1_data.txt").printWriter()
    for (word in words){
        println(word)
        writer.println(word)
    }
    writer.close()
}

fun c1(){
    // TODO
}