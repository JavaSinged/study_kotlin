package main.java.chap08

/*
* 제네릭 클래스
* - 형식 매개변수를 1개 이상 받는 클래스
*
* class MyClass<T> { //1개의 형식 매개변수를 가지는 클래스
*   fun myMethod(a: T) { //메서드의 매개변수 자료형에 사용됨
*       ...
*   }
* }
*
* 오류
* class MyClass<T> {
*   var myProp: T //프러퍼티는 초기화되거나 abstract로 선언되어야함
* }
*
* class MyClass<T>(val myProp: T){} //주 생성자의 프로퍼티
*
* 주 생성자나 부 생성자에 형식 매개변수를 지정해 사용함
* class MyClass<T> {
*   val myProp: T //프로퍼티
*   constructor(myProp: T) { //부 생성자 이용
*       this.myProp = myProp
*   }
* }
*
* var a = MyClass<Int>(12)
* println(a.myProp) //12
* println(a.javaClass) //MyClasss
* */

open class Parent

class Child: Parent()

class Cup<T>

fun main() {
    val obj1: Parent = Child() //Parent 형식의 obj1은 Child의 자료형으로 변환될 수 있음
    val obj2: Child = Parent() //오류! 자료형 불일치

    val obj3: Cup<Parent> = Cup<Child>() //오류! 자료형 불일치
    val obj4: Cup<Child> = Cup<Parent>() //오류! 자료형 불일치

    val obj5 = Cup<Child>() //obj5는 Cup<Child>의 자료형이 됨
    val obj6L Cup<Child> = obj5 //자료형이 일치하므로 가능
}