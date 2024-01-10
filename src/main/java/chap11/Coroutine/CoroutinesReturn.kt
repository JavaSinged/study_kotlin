package main.java.chap11.Coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
* launch 코루틴 빌더 생성
* launch 이외에도 코루틴 블록을 생성할 수 있느 몇 가지 방법이 있다.
* launch는 현재 스레드를 차다하지 않고 새로운 코루틴을 실행할 수 있게 하며 특정 결괏값 없이 job 객체를 반환함.
*/

//job 객체를 받아 코루틴의 상태를 출력해보느 예제
fun main() {
    val job = GlobalScope.launch { // Job 객체의 반환
        delay(1000L)
        println("World!")
    }

    println("Hello, ")
    println("job.isActive: ${job.isActive}, completed: ${job.isCompleted}") //false
    Thread.sleep(2000L)
    println("job.isActive: ${job.isActive}, completed: ${job.isCompleted}") //true
}