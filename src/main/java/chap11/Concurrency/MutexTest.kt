package main.java.chap11.Concurrency

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis

/*
* 상호배제는 코드가 임계 구역에 있는 경우 절대로 동시성이 일어나지 않게 하고 하나의 루틴만 접근하는 것을 보장함.
* 임계 구역 또는 공유 변수 영역은 병렬 컴퓨팅에서 둘 이상의 스레드가 동시에 접근해서는 안 되는 배타적 공유 자원의 영억으로 정의함.
* 임계 구역은 잘못된 변경이 일어나지 않도록 보호해야 하는 코드가 있는 구역이므로 임계 영역의 처리가 필요한 경우 임계 구역에 들어간
* 루틴은 다른 루틴이 못 들어오도록 잠가야 함.
* 상호 배제의 특징으로 소유자 개념이 있는데 일단 잠근 루틴만이 잠금을 해제할 수 있다는 뜻임.
* 다른 루틴은 잠금을 해제할 수 없음. 자바에서는 비슷한 개념으로 보통 synchronized 키워드를 사용해 코드를 보호했음.
* 코틀린의 코루틴에서는 Mutex의 lock과 unlock을 사용해 임계구역을 만들 수 있음.
* */

val mutex = Mutex()
var counter3 = 0

suspend fun massive(action: suspend () -> Unit) {
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

fun main() = runBlocking {
    massive {
        mutex.withLock {
            counter3++
        }
    }
    println("Counter = $counter3")

}