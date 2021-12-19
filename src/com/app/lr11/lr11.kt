package com.app.lr11

import java.io.File
import java.io.FileOutputStream

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class Auto(val mark:String, val mas: Long, val year: Int, var price: Double) {
    override fun toString(): String{
        return "Auto(mark=$mark;mas=$mas;year=$year;price=$price)"
    }

    companion object Factory{
        fun create(s: String): Auto {
            val data = s.trim().split(';')
            return Auto(data[0], data[1].toLong(), data[2].toInt(), data[3].toDouble())
        }
    }
}

fun createFile_a1(fileName: String){
    val autos = arrayOf(Auto("Ford Focus 1", 1500, 2005, 300000.0),
                        Auto("Жигули 2101", 1350, 1970, 25000.0))
    for ((idx, auto)in autos.withIndex()){
        val dataToWrite = Gson().toJson(auto).toString() + '\n'
        FileOutputStream(fileName, idx != 0).write(dataToWrite.toByteArray(Charsets.UTF_8))
    }
}

fun readFile_a1(fileName: String): List<Auto>{
    val dataRepr = File(fileName).readBytes().toString(Charsets.UTF_8)
    val dataAsLst = dataRepr.split('\n').filter { it.isNotEmpty() }
    val dataObjs: List<Auto> = dataAsLst.map {
        Gson().fromJson(it, object : TypeToken<Auto>() {}.type)
    }
    return dataObjs

}

fun findNewest(autos: List<Auto>): List<Auto>{
    val latestYear = autos.map { it.year }.minOrNull()
    return autos.filter { it.year == latestYear }

}

fun a1(){
    println("Создаем файл...")
    createFile_a1("./assets/test.bin")
    println("Читаем файл...")
    val autos = readFile_a1("./assets/test.bin")
    println(autos.toString())
    val count = autos.size
    println("В файл $count объектов")
    val newest = findNewest(autos)
    print("Количество самых новых автомобилей: ${newest.size}")
}

class Book(val number: Int, val authorName: String, val bookName: String, val year: Int, val price: Float) {
    override fun toString(): String{
        return "$number;$authorName;$bookName;$year;$price"
    }

    companion object Factory{
        fun create(s: String): Book {
            val data = s.trim().split(';')
            return Book(data[0].toInt(), data[1], data[2], data[3].toInt(), data[4].toFloat())
        }
    }
}

fun createFile_b1(fileName: String){
    val books = arrayOf(Book(1, "Иван Иванов", "Котлин для начинающих", 2015, 2500.0F),
                        Book(2, "Петр Петров", "Python для начинающих", 2013, 4500.0F),
                        Book(3, "Сергей Сергеев", "C++ для начинающих", 2018, 500.0F),
                    )
    for ((idx, book) in books.withIndex()){
        val dataToWrite = Gson().toJson(book).toString() + '\n'
        FileOutputStream(fileName, idx != 0).write(dataToWrite.toByteArray(Charsets.UTF_8))
    }
}

fun addBooksInFile(fileName: String){
    val newBooks = arrayOf(Book(4, "Иван Иванов", "Java для начинающих", 2010, 3200.0F),
                           Book(5, "Петр Петров", "Pascal для начинающих", 1990, 4500.0F))
    for ((idx, book) in newBooks.withIndex()){
        val dataToWrite = Gson().toJson(book).toString() + '\n'
        FileOutputStream(fileName, true).write(dataToWrite.toByteArray(Charsets.UTF_8))
    }
}

fun readFile_b1(fileName: String): List<Book>{
    val dataRepr = File(fileName).readBytes().toString(Charsets.UTF_8)
    val dataAsLst = dataRepr.split('\n').filter { it.isNotEmpty() }
    val dataObjs: List<Book> = dataAsLst.map {
        Gson().fromJson(it, object : TypeToken<Book>() {}.type)
    }
    return dataObjs

}

fun createOutFile_b1(books: List<Book>, outputFile: String){
    val maxPrice = books.map { it.price }.maxOrNull()
    val mostExpBooks = books.filter { it.price == maxPrice }
    for ((idx, book) in mostExpBooks.withIndex()){
        val dataToWrite = Gson().toJson(book).toString() + '\n'
        FileOutputStream(outputFile, true).write(dataToWrite.toByteArray(Charsets.UTF_8))
    }

}

fun b1(){
    val fileName = "./assets/lr11_b1.bin"
    createFile_b1(fileName)
    println("Книги до добавления: ")
    println(readFile_b1(fileName).toString())
    addBooksInFile(fileName)
    println("Книги после добавления: ")
    println(readFile_b1(fileName).toString())
    val books = readFile_b1(fileName)
    val outFileName = "./assets/lr11_b1_out.bin"
    createOutFile_b1(books, outFileName)
    println("Самые дорогие книги:")
    println(readFile_b1(outFileName).toString())


}

fun c1(){
    // TODO
}