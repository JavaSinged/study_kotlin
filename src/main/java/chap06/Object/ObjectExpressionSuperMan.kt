package main.java.chap06.Object

open class Superman() {
    fun work() = println("Taking photos")
    fun talk() = println("Talking with people.")
    open fun fly() = println("Flying in the air")
}

fun main() {
    val pretendedMan = object : Superman() { // object 표현식으로 flt() 구현의 재정의
        override fun fly() = println("I'm not a real superman. I can't fly!")
    }

    pretendedMan.work()
    pretendedMan.talk()
    pretendedMan.fly()
}