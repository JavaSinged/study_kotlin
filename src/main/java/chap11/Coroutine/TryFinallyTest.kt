package main.java.chap11.Coroutine

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>{
    val job = launch {
        try {
            repeat(1000){ i ->
                println("I'm Ssleeping $i...")
                delay(500L)
            }
        }finally {
            println("Bye!")
            //1초 이후에도 println() 함수를 실행을 보장하는 예
            withContext(NonCancellable){
                println("I'm running finally")
                delay(1000L)
                println("Non-cancellable") //1초를 지연해도 취소되지 않음.
            }
        }
    }
    delay(1300L)
    job.cancelAndJoin() // 작업을 취소하고 완료될 때까지 기다림
    println("main: Quit!")

}

/*
* 일반적인 finally 블록에서 지연 함수를 사용하려고 하면 코루틴이 취소되므로 지연함수를 사용할 수 없음.
* 그 외에 파일을 닫거나 통신 채널을 닫는 등의 작업은 넌블로킹 형태로 작동하며 지연 함수를 포함하고 있지 않기 때문에 문제가 없음.
* 만일 finally 블록에 시간이 걸리는 작업이나 지연 함수가 사용될 경우 실행을 보장하기 위해서는 NonCancellanble 문맥에서
* 작동하도록 해야함.
* 이것을 위해 withContext(NonCancellable){..}을 사용해 다음과 같이 finally 블록을 구성할 수 있음.
* */