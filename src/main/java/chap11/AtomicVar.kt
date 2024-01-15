package main.java.chap11

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

/*
* 원자변수란 특정 변수의 증가나 감소, 더하기나 빼기가 단일 기계어 명령으로 수행되는 것을 말하며 해당 연산이 수행되는 도중에는
* 누구도 방해하지 못하기 때문에 값의 무결성을 보장할 수 있게됨.
* 단일 기계어 명령이란 CPU가 명령을 처리할 때의 최소 단위임.
* */

//var counter = 0 //병행 처리 중 문제가 발생할 수 있는 변수
var counter = AtomicInteger(0) // 원자변수로 초기화

suspend fun massiveRun(action: suspend ()->Unit){
    val n = 1000 //실행할 코루틴의 수
    val k = 1000 // 각 코루틴을 반복할 수

    val time = measureTimeMillis {
        val jobs = List(n){
            GlobalScope.launch {
                repeat(k){action()}
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n*k} actions in $time ms")
}

fun main() = runBlocking{
    massiveRun {
//        counter++ // 증가 연산에서 값에서 무결성에 문제가 발생할 수 있음.
        counter.incrementAndGet() //원자 변수의 멤버 메서드를 사용해 증가
    }
//    println("Counter = $counter")
    println("Counter = $counter.get")
}

/*
* 이 코드에서는 counter 변수의 값을 증가시키는 연산을 하고 있음.
* 순차적 프로그램에서는 문제가 없으나 많은 수의 독립적이 루틴이 이 코드에 접근해 counter를 공유하면 언제든 코드가 중단될 수 있음
* 을 생각해야함. 중단 시점은 CPU의 최소 단위인 명령어가 실행될 때 결정됨. 코드사에서는 counter++이라는 한줄의 코드이지만
* 이것이 컴파일되서 CPU가 실행할 명령어로 변환되면 여러 개의 명령으로 분할되므로 프로그래머가 예상하지 못한 결과를 초래할 수 있음.
* 즉, counter의 증가를 시작했지만 CPU의 최소 명령어가 마무리되지ㅣ 않은 시점에 루틴이 중단ㄷ뇌ㅣ어서 다른 루틴이 counter를
* 건드릴 수 있음. 코드상에서는 한 줄로 작성된 코드에 진입한 것처럼 보이지만 결국 내부적으로는 값이 증가되지 못하고 다른 루틴이
* 실행되어 버린 것. 이때 다른 루틴이 해당 변수를 조작할 수 있기 때문에 값의 무결성을 보장할 수 없게됨. 이렇게 되면 실행 결과가
* 매번 달라질 수 있게됨.
* 원자 변수를 사용하면 이때 counter의 증가 연산 부분을 CPU의 기계어 명령 하나로 컴파일 하게됨.
* 따라서 값이 무결성을 보장함.
* */