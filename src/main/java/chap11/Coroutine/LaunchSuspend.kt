package main.java.chap11.Coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun doWork1(): String {
    delay(1000)
    return "Work1"
}

suspend fun doWork2(): String {
    delay(3000)
    return "Work2"
}

private fun worksInSerial() {
    //순차적 실행
    GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()
        println("Kotlin One: $one")
        println("Kotlin Two: $two")
    }
}

//async 코루틴 빌더 생성하기
private fun worksInParallel() {
    //Deferred<T>를 통해 결괏값을 반환
    val one = GlobalScope.async {
        doWork1()
    }

    val two = GlobalScope.async {
        doWork2()
    }

    GlobalScope.launch {
        val combined = one.await() + "_" + two.await()
        println("Kotlin Combined: $combined")
    }
}
/*
* 복잡한 루틴을 작성하는 경우에 많은 태스트들과 같이 병행 수행되므로 어떤 루틴이 먼저 종료될지 알기 어려움.
* 따라서 태스크가 종료되는 시점을 기다렸다가 결과를 받을 수 있도록 await()를 사용해 현재 스레드의 블로킹 없이 먼저 종료되면
* 결과를 가져올 수 있음.
* combine라는 변수에 2개의 비동기 루틴이 종료되고 결과가 반환되면 문자를 합쳐서 할당함.
* - 주로, 안드로이드 UI스레드에서 블로킹 가능성이 있는 코드를 사용하면 애플리케이션이 중단되거나 멈추는 경우가 발생할 수
* 있는데, 이 경우 await()를 사용하면 UI를 제외한 루틴만 블로킹되므로 UI가 멈추는 경우를 해결할 수 있음.
* */

fun main() {
    worksInSerial()
    worksInParallel()
    readLine() //main이 먼저 종료되는 것을 방지하기 위해 콘솔에서 Enter키 입력 대기
}