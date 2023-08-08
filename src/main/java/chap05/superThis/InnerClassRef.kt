package chap05.superThis

/*
* 이너 클래스에서 바깥 클래스 접근하기
* - 이너 클래스에서 바깥 클래스의 상위 클래스를 호출하려면
*  super 키워드와 함께 @ 기호 옆에 바깥 클래스 이름을 작성 해야함.
* */

open class Base{
    open val x: Int = 1
    open fun f() = println("Base Class f()")
}

class Child : Base(){
    override val x: Int = super.x + 1
    override  fun f() = println("Child Class f()")

    inner class Inside{
        fun f() = println("Inside Class f()")
        fun test(){
            f() //현재 이너 클래스의 f() 접근
            Child().f() //바롤 바깥 클래스의 f() 접근
            super@Child.f() //Child의 상위 클래스인 Base 클래스의 f() 접근
            println("[Inside] super@CHild.x: ${super@Child.x}") //Base의 x 접근
        }
    }
}

fun main() {
    val c1 = Child()
    c1.Inside().test()
}