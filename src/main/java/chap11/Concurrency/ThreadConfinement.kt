package main.java.chap11.Concurrency

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

/*
* 특정 문맥에서 작동하도록 단일 스레드에 가두는 방법이 있음.
* 보통 UI 애플리케이션에서 UI 상태는 단일 이벤트에 따라 작동해야함.
* 이때 단일 스레드 문맥인 newSingleThreadContext를 사용할 수 있음.
* */

//단일 스레드 문맥을 선언
val counterContext = newSingleThreadContext("CounterContext")
var counter2 = 0

suspend fun massiveRun(context:CoroutineContext, action: suspend ()->Unit){
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n){
            GlobalScope.launch(context){
                repeat(k){action()}
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actionsss in $time ms")
}

fun main() = runBlocking{
    //처리가 느린 방법
//    massiveRun {
//        withContext(counterContext){ //단일 스레드에 가둠
//            counter2++
//        }
//    }

    //처리가 빠른 방법
    massiveRun(counterContext){
        counter2++
    }
    println("Counter = $counter2")
}