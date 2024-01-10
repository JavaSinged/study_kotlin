package main.java.chap11.Coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlinx.coroutines.runBlocking

//main()을 블로킹 모드로 동작시키기
fun main() = runBlocking<Unit> {//main() 함수가 코루틴 환경에서 실행
    launch { //백그라운드로 코루틴 실행
        delay(1000L)
        println("World!")
    }

    println("hello") //즉시 이어서 실행됨

}
