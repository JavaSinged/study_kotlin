package main.java.chap08.Array

//2차원 배열을 평탄화 하기

fun main() {
    val numbers = arrayOf(1, 2, 3)
    val strs = arrayOf("one", "two", "three")
    val simpleeArray = arrayOf(numbers, strs) //2차원 배열

    simpleeArray.forEach { println(it) }

    val flattenSimpleArray = simpleeArray.flatten() //단일 배열로 변경
    println(flattenSimpleArray)

}