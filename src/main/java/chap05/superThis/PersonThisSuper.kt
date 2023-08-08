package chap05.superThis

/* 여러 개의 부 생성자에서 참조하기

* developer 클래스의 1번 생성자로 진입
* this 키워드에 의해 firstName, 10을 가지고 developer 클래스의 2번 생성자를 호출
* super 키워드에 의해 상속하고 있는 상위 클래스 Person의 2번 생성자를 호출함
* */

open class Person{
    constructor(firstName:String){
        println("[Person] firstName: $firstName")
    }
    constructor(firstName:String, age: Int){
        println("[Person] firstName: $firstName, $age")
    }
}

class Developer: Person{
    constructor(firstName: String): this(firstName, 10){
        println("[Developer] $firstName")
    }
    constructor(firstName: String,age: Int): super(firstName, age){
        println("[Developer] $firstName, $age")
    }
}

fun main() {
    val sean = Developer("Sean")
}