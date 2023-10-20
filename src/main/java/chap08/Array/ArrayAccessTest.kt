package main.java.chap08.Array

import java.util.*

//배열 선언 및 접근 연습하기

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)

    println("arr: ${Arrays.toString(arr)}")
    println("size: ${arr.size}")
    println("sum(): ${arr.sum()}")

    //getter에 의한 접근과 대괄호 연산자 표기법
    println(arr.get(2))
    println(arr[2])

    //setter에 의한 값의 설정
    arr.set(2, 7)
    arr[0] = 8

    println("size: ${arr.size}, arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")

    for (i in 0..arr.size -1){
        println("arr[$i] = ${arr[i]}")
    }
}