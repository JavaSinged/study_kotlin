package main.java.chap08.Generic

interface InterfaceA

interface InterfaceB

class HandlerA: InterfaceA, InterfaceB

class HandlerB: InterfaceA

class ClassA<T> where T: InterfaceA, T: InterfaceB //2개의 인터페이스를 구현하는 클래스로 제한

fun main() {
    val obj1 = ClassA<HandlerA>()
//    val obj2 = ClassA<HandlerB>() <- 범위에 없으므로 오류 ㅂㅏㄹ생
}