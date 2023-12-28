package main.java.chap10.StandardLibrary

/*
* run() 함수는 인자가 없는 익명 함수처럼 동작하는 형태와 객체에서 호출하는 형태, 2가지로 사용할 수 있음.
* 객체 없이 run() 함수를 사용하면 인자 없는 익명 함수처럼 사용할 수 있음.
* */

fun main() {
    var skills = "Kotlin"
    println(skills) //Kotlin

    val a = 10
    skills = run {
        val level = "Kotlin Level: " + a
        level //마지막 표현식이 반환됨
    }
    println(skills) //Kotlin Level: 10

    data class Person(var name: String, var skills: String)
    var person = Person("Kildong", "Kotlin")
    val returnObj = person.apply {
        this.name = "Sean"
        this.skills = "Java"
        "success" //사용되지 않음
    }
    println(person)
    println("returnObj: $returnObj")

    val returnObj2 = person.run {
        this.name = "Dooly"
        this.skills = "C#"
        "success"
    }
    println(person)
    println("returnObj2: $returnObj2")
}

/*
* run() 함수도 해당 객체를 this로 받아 변경할 수 있지만 apply() 함수는 this에 해당하는 객체를 반환한 반면에,
* run() 함수는 마지막 표현식 "success"를 반환했음을 알 수 있음.
* */