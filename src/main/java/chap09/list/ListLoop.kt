package main.java.chap09.list

fun main() {
    //각 요소 순환하기
    val fruits = listOf("apple", "banana", "kiwi")
    for (item in fruits)
        println(item)

    for (index in fruits.indices) //인덱스 지정
        println("fruits[$index] = ${fruits[index]}")

    var index = 0
    while (index < fruits.size) { //while문 사용
        println("fruits[$index] = ${fruits[index]}")
        index++
    }
}