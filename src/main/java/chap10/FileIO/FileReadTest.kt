package main.java.chap10.FileIO

import java.io.FileReader

fun main() {
    val path = "/Users/sinjiung/Desktop/Over the Rainbow.txt"

    try {
        val read = FileReader(path)
        println(read.readText())
    } catch (e: Exception) {
        println(e.message)
    }

}