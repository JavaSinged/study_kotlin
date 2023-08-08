package main.java.chap06.DelayInitialization

/*
* lazy
* - 호출 시점에 by lazy{} 정의에 의해 블록 부분의 초기화를 진행함
* - 불변의 변수 선언인 val에서만 사용 가능함
* - val이므로 값을 다시 변경할 수 없음
*
* */
class LazyTest {
    init {
        println("init block")
    }

    val subject by lazy {
        println("lazy initialized")
        "Kotlin Programming" // << 람다식의 맨 마지막 문장이 반환값이 됨
    }

    fun flow() {
        println("not initialized")
        println("subject one: $subject") // << subject 값이  최초로 접근되는 부분
        println("subject two: $subject") // << subject 값이 이미 초기화된 값임
    }
}

fun main() {
    val test = LazyTest()
    test.flow()
}