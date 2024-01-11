package main.java.chap11.Coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    GlobalScope.launch {
        //만일 launch만 사용하면 종료되지 않음
        repeat(1000) { i ->
            println("I'm sleeping $i...")
            delay(500L)
        }
    }
    delay(1300L)
}

/*
* 1000회를 반복하기 위해 repeat() 함수에 1000이라는 인자를 주고 있음.
* 1.3초 뒤 종료되므로 약 3번 정도만 진행되고 중단됨.
* 만일 GlobalScope를 제거하면 모든 횟수를 진행할 때까지 프로그램이 종료되지 않음.
* */