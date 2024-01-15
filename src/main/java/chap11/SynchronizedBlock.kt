package main.java.chap11


/*
* 병행 프로그래밍에서는 전역 변수 같은 변경 가능한 공유 자원에 접근할 때 값의 무결성을 보장할 수 있는 방법이 필요함.
* 자바에서는 synchronized 키워드를 사용해 메서드나 특정 코드를 동기화하고 보호함.
* 코틀린에서는 추가로 공유 자원의 보호와 스레드 안ㄴ전ㄴ을 구현하기 위해 원자 변수, 스레드 가두기, 상호 배제 등을 사용할 수 있음.
*
* 동기화 기법
* - 스레드 간 서로 공유하는 데이터가 있을 때 동기화해서 데이터의 안정성을 보장함.
* - 특정 스레드가 이미 자원을 사용하는 중이면 나머지 스레드의 접근을 막는 것
* */
var global = 20

@Synchronized fun synchronizedMethod(){
    global += 1
    println("${Thread.currentThread()} global = $global")
}

fun main() {
    synchronizedMethod()
}