package main.java.chap11.Coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//많은 양의 작업 생성하기
fun main() = runBlocking {
    val jobs = List(100_000) {//많은 양의 코루틴을 위한 List
        launch {
            delay(1000L)
            print(".")
        }
    }
    jobs.forEach { it.join() } //모든 jobs가 완료될때까지 기다림

    //repeat()를 사용해 많은 양의 코루틴을 생성할 수 있음.
    repeat(100_000){
        launch {
            delay(1000L)
            print("#")
        }
    }
}

/*
* 이런 코드를 스레드롤 바꾸면 Out-of-memory 오류가 발생함.
* 하지만 코루틴으로 작업하면 내부적으로 단 몇 개의 스레드로 수많은 코루틴을 생성해 실행할 수 있기 때문에 오류가 발생하지 않음
* 또 메모리나 실행 속도 면에서 큰 장점을 가짐.
* */