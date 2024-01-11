package main.java.chap11.Coroutine

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    try {
        withTimeout(1300L) {//Timeout 예외 발생, null로 처리하는 경우 withTimeoutOrNull()을 사용
            repeat(1000) { i ->
                println("I'm sleeping $i...")
                delay(500L)
            }
        }
    } catch (e: TimeoutCancellationException) {
        //시간이 만료되면 block을 취소시키고 TimeoutCancellationException오류가 발생하는 코드임.
        //예외를 발생하지 않고 null로 처리하려면 withTimeoutOrNull()을 사용함.
        println("timed out with $e")
    }
}