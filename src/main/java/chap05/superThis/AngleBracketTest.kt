package chap05.superThis

/*
* 앵글 브래킷을 사용한 이름 중복 해결하기
*
* */

open class A {
    open fun f() = println("A Class f()")
    fun a() = println("A Classs a()")
}

interface B {
    fun f() = println("B Interface f()")
    fun b() = println("B Class b()")
}

class C : A(), B {
    override fun f() = println("C Class f()")

    fun test() {
        f()
        b()
        super<A>.f()
        super<B>.f()
    }
}

fun main() {
    val c = C()
    c.test()
}