package main.java.chap11.Coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//시작 시점 늦춰 보기
suspend fun doWork3(): String {
    delay(1000)
    return "Work!"
}

suspend fun doWork4(): String {
    delay(3000)
    return "Work2"
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doWork3() }
        val two = async(start = CoroutineStart.LAZY) { doWork4() }
        println("AWAIT: ${one.await() + "_" + two.await()}")
    }
    println("Completed in $time ms")
}
