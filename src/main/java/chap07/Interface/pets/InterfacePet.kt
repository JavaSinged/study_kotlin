package main.java.chap07.Interface.pets

/*
* 인터페이스 interface
* - 인터페이스에는 abstract로 정의된 추상 메서드나 일반 메서드가 포함됨
* - 메서드에 구현 내용이 포함될 수 있음. 단, 프로퍼티를 통해 상태를 저장할 수 없음 (선언만 가능)
*
* - 구성
* interface name {
*   추상 프로퍼티 선언
*   추상 메서드 선언
*
*   일반메서드 선언 {}
* }
* */

interface Pet {
    var category: String
    var species: String

    val msgTags: String //val 선언 시 게터의 구현 가능
        get() = "I'm your lovely pet!"

    fun feeding() //추상 메서드

    fun patting() { //비 추상 메서드
        println("Keep patting!")
    }
}

class Cat(name: String, override var category: String) : Pet, Animal(name) {

    override var species: String = "cat" //오버라이딩하여 종 특정

    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("Bill", "small")
    println("Pat Category: ${obj.category}")
    println("Pet Message Tags: ${obj.msgTags}")
    obj.feeding()
    obj.patting()
}