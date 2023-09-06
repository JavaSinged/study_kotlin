package main.java.chap07.moreClass

//중첩 클래스

class Outer{
    val ov = 5
    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello! $nv" // 외부의 ov에는 접근 불가
    }

    fun outside(){
        val msg = Nested().greeting() // 객체 생성 없이 중첩 클래스의 메서드 접근
        println("[Outer]: $msg, ${Nested().nv}") // 중첩 클래스의 프로퍼티 접근
    }
}

fun main() {
    // static처럼 객체 생성 없이 사용
    val ouput = Outer.Nested().greeting()
    println(ouput)

    val outer = Outer()
    outer.outside()
}