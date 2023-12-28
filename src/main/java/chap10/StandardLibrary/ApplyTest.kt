package main.java.chap10.StandardLibrary

/*
* apply() 함수는 also() 함수와 마찬가지로 호출하는 객체 T를 이어지는 block으로 전달하고 객체 자체인 this를 반환함
* apply() 함수는 특정 객체를 생성하면서 함께 호출해야 하는 초기화 코드가 있는 경우 사용할 수 있음.
* apply() 함수와 also() 함수의 다른 점은 T.()와 같은 표현에서 람다식이 확장 함술로 처리된다는 것임.
* */

fun main() {
    data class Person(var name : String, var skills: String)
    var  person = Person("Kildong", "Kotlin")
    person.apply { this.skills = "Swift" } //여기서 this는 person 객체를 가리킴
    println(person)

    val returnObj = person.apply {
        name = "Sean" //this는 생략할 수 있음
        skills = "Java" //this 없이 객체의 멤버에 여러 번 접근
    }

    println(person)
    println(returnObj)

    /*
    * apply()는 확장 함수로서 person을 this로 받아오는데 클로저를 사용하는 방식과 같음.
    * 따라서 객체의 프로퍼티를 변경하면 원본 객체에 반영되고 또한 이 객체는 this로 반환됨
    * this.name = "Sean"과 같은 표현은 this가 생략 가능하기 때문에 name = "Sean"과 같이 작성할 수 있음.
    * 이때 this로부터 반환된 객체 returnObj에 할당하고 있음.
    * also()함수와 차이점은 객체를 넘겨받는 방법이 다름.
    * also() 함수에서는 it을 사용해 멤버에 접근함.
    * */
}