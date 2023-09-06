package main.java.chap08

/*
* 제네릭
* - 클래스 내부에서 사용할 자료형을 나중에 인스턴스를 생성할 때 확정함
* - E : 요소
* - K : 키
* - N : 숫자
* - T : 형식
* - V : 값
* */

class Box<T>(t:T) {
    //형식 매개변수로 받은 인자를 name에 저장
    var name = t
}

fun main() {
    val box1: Box<Int> = Box<Int>(1)
    val box2: Box<String> = Box<String>("Hello")
    println(box1.name)
    println(box2.name)
}