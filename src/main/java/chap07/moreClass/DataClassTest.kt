package main.java.chap07.moreClass

/*
* DTO(Data Transfer Object) : 데이터 전달을 위한 객체
* 내부적으로 자동 생성되는 메서드
* - 프로퍼티를 위한 getter/setter
* - 비교를 위한 equals()와 키 사용을 위한 hashCode()
* - 객체 복사를 위한 copy()
* - 프로퍼티에 상응하는 component1(), component2() 등
* */

/*
* 데이터 클래스 조건
* - 주 생성자는 최소한 하나의 매개변수를 가져야 함
* - 주 생성자의 모든 매개변수는 val, var로 지정된 프로퍼티여야 함
* - 데이터 클래스는 abstract, open, sealed, inner 키워드를 사용할 수 없음
* */

data class Customer(var name: String, var email: String) {
    var job: String = "Unknown"

    constructor(name: String, email: String, _job: String) : this(name, email) {
        job = _job
    }

    init {
        //간단 로직 작성
    }
}

//자동 생성 메서드

fun main() {
    val cus1 = Customer("Sean", "sean@mail.com")
    val cus2 = Customer("Sean", "sean@mail.com")
    val bob = Customer("Bob", "sean@mail.com")
    val erica = Customer("Erica", "sean@mail.com")


    //equals, hashCode
    println(cus1 == cus2)
    println("${cus1.hashCode()}, ${cus2.hashCode()}")

    //copy, toString
    val cus3 = cus1.copy(name = "Alice")
    println(cus1.toString())
    println(cus3.toString())
    println(cus1 == cus3)
    println("${cus1.hashCode()}, ${cus3.hashCode()}")

    //Destructuring : 객체가 가지고 있는 프로퍼티를 개별ㄹ 변수로 분해하여 할당하는 것
    val (name, email) = cus1
    /*
    * val (_, email) = cus1 < 특정 프로퍼티를 가져올 필요가 없을 경우 _를 사용함
    * val name2 = cus1.component1() < cus1의 name
    * val email2 = cus1.component2() < cus1의 emiail
    * */

    println("name = $name, email = $email")

    //반복문 Destructuring
    val customers = listOf(cus1, cus2, bob, erica)

    for ((name, email) in customers) {
        println("name = $name, email = $email")
    }

    //함수로 부터 객체가 봔환될 경우
    val (myName, myEmail) = myFunc()

    //람다식
    val myLamda = {
        (nameLa, emailLa): Customer ->
        println(nameLa)
        println(emailLa)
    }
    myLamda(cus1)
}

fun myFunc(): Customer {
    return Customer("Mickey", "mic@abc.com")
}