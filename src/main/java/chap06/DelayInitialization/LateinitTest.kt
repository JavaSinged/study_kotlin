package main.java.chap06.DelayInitialization

/*
* lateinit
* - 프로퍼티 선언할 때 null을 허용하지 않아서
* 프로퍼티 지연 초기화 키워드를 사용하여 값이 바로 할당되지 않아도 컴퍼일되게 함
* - 단 실행할 때까지 값이 비어 있으면 오류를 유발할 수 있음
* - var로 선언된 프로퍼티만 가능
* - 프로퍼티에 대한 get, set 사용 불가
* */

class Person{
     lateinit var name:String

    fun test(){
        if (!::name.isInitialized){ // 프로퍼티 초기화 확인
            println("not initialized")
        }else{
            println("initialized")
        }
    }
}

fun main() {
    val kildong = Person()
    kildong.test()
    kildong.name = "Kildong" // 지연 초기화 시점
    kildong.test()
    println("name = ${kildong.name}")
}