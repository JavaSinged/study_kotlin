package main.java.chap08.Generic

import java.lang.IllegalStateException

//refied를 이용한 결정되지 않은 제네릭 자료형의 처리

fun main() {
    val result = getType<Float>(10)

    println("result = $result")
}

inline fun <reified T> getType(value: Int): T {
    println(T::class)
    println(T::class.java)

    return when (T::class) { //받아들인 제네릭 자료형에 따라 반환
        Float::class -> value.toFloat() as T
        Int::class -> value as T
        else -> throw IllegalStateException("${T::class} is not supported!")
    }
}