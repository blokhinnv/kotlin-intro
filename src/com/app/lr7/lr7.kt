package com.app.lr7

import com.app.common.printArray
import java.util.regex.Pattern

fun a1(){
    val s = "Напечатать_все_Cл0ва,_начинающиеся!на;большую И:заканчивающиеся\n" +
            "на меленькую букву."
    println("Исходный текст: \n $s")
    val delimiterPattern = Pattern.compile("[_.,;:\\n\\t!?]")
    val words = s.split(delimiterPattern)
    for (word in words){
        if (word.isNotEmpty() && word.first().isUpperCase() && word.last().isLowerCase())
            println(word)
    }
}

fun b1(){
    val s = "Напечатать_все_Сл+ва,_начиннающиеся!на;большую И:заканчивающиеся\n" +
            "на меленькую букву."
    println("Исходный текст: \n $s")
    val delimiterPattern = Pattern.compile("[_.,;:\\n\\t!?]")
    val words = s.split(delimiterPattern)
    var counter = 0
    var foundWords = ArrayList<String>()

    val signRegex= "[А-Я].*[+\\-*\\/^].*".toRegex()
    val repetitionRegex = "([\\wа-яА-Я])\\1".toRegex()
    for (word in words){
        if (signRegex.matches(word))
            counter += 1
        if (repetitionRegex.containsMatchIn(word))
            println("$word содержит две рядом стоящие одинаковые буквы")
    }
    println("Количество слов, начинающихся на большую букву и содержащих хотя бы один арифметический знак: $counter")

}

fun c1(){
    // TODO
}