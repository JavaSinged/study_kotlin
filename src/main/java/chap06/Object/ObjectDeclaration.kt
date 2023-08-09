package main.java.chap06.Object

/*
* Object 선언
* - object로 선언된 클래스는 멤버 프로퍼티와 메서드를 객체 생성 없이 이름의 점 표기법으로 바로 사용할 수 있음
* - 접근 시점에 객체가 생성됨 따라서 생성자 호출을 하지 않기 떄문에 생성자를 사용하지 못함
* - init이 최초 접근에서 실행됨
* - object 선언에서도 클래스나 인터페이스를 상속할 수 있음
* */

//object 키워드 방식
object OCustomer{
    var name = "Kildong"
    fun greeting() = println("Hello World!")
    val HOBBY = Hobby("Basketball")
    init {
        println("Init!")
    }
}

//컴패니언 객체 방식
class CCustomer{
    companion object{
        const val HELLO = "hello"
        var name = "Joosol"
        @JvmField val HOBBY = Hobby("Football")
        @JvmStatic fun greeting() = println("Hello World")
    }
}

class Hobby(val name: String)

fun main() {
    OCustomer.greeting()
    OCustomer.name = "Dooly"
    println("name = ${OCustomer.name}")
    println(OCustomer.HOBBY.name)

    CCustomer.greeting()
    println("name = ${CCustomer.name}, HELLO = ${CCustomer.HELLO}")
    println(CCustomer.HOBBY.name)
}