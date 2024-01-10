package main.java.chap11.Coroutine

import kotlinx.coroutines.*
/*
* 코루틴
* - 비용이 많이 드는 문맥 교환 없이 해당 루틴을 일시 중단해서 이러한 비용을 줄일 수 있음.
* - 다르게 표현하면 운영체제가 스케줄링에 개입하는 과정이 필요하지 않다는 것
* - 또한 일시 중단은 사용자가 제어할 수 있음.
*
* common 패키지의 주요 기능
* - launch / async : 코루틴 빌더
* - Job / Deferred : cancellation 지원
* - Dispatchers : Default는 백그라운드 코루틴을 위한 것이고 Main은 Andriod나 Swing, JavaFx를 위해 사용
* - delay / yield : 상위 레벨 지연 함수
* - Channel / Mutex : 통신과 동기화를 위한 기능
* - coroutineScope / supervisorScope : 범위 빌더
* - select : 표현식 지원
*
* core 패키지의 주요 기능
* - CommeonPool : 코루틴 문맥
* - produce / actor : 코루틴 빌더
*
* 코루틴에서 사용되는 함수는 suspend()로 선언된 지연 함수여야 코루틴 기능을 사용할 수 있음.
* susspend로 표기함으로서 이 함수는 실행이 일시 중단 될 수 있으며 피료한 경우에 다시 재개할 수 있게 함
*
* */

suspend fun doSomething(){
    println("Do something!")
}

fun main() { //메인 스레드의 문맥
    GlobalScope.launch { // 새로운 코루틴을 백그라운드에 실행
        delay(1000L) // 1초의 넌블로킹 지연(시간의 기본단위는 ms)
        println("World!") // 지연 후 출력
        doSomething()
    }
    println("Hello, ") // 메인 스레드의 코루틴이 지연되는 동안 계속 실행
    Thread.sleep(2000L) //메인 스레드가 JVM에서 바로 종료되지 않게 2초 기다림

}