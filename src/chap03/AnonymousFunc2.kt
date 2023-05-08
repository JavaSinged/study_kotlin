package chap03

fun main() {

    normal()
    greet() // 무엇이 프린트 될까요?
    greetAnon() // 익명의 함수
}

fun normal() { println("Hello1") }

fun greet() = { println("Hello2") }

fun greetAnon() = fun() { println("Hello3") }