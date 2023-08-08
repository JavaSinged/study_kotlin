package main.java.chap06.DelayInitialization

class Person1(val name: String, val age: Int)

fun main() {
    var isPersonInstantiated: Boolean = false

    val person: Person1 by lazy {
        isPersonInstantiated = true
        Person1("Kim", 23)
    }

    val personDelegate = lazy { Person1("Hong", 40) }

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}")
    println("personDelegate Init: ${personDelegate.value.name}")

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
}