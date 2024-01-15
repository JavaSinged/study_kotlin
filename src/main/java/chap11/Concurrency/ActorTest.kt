package main.java.chap11.Concurrency

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlin.system.measureTimeMillis

/*
* 코루틴의 결합으로 만든 actor는 코루틴과 채널에서 통신하거나 상태를 관리함.
* 다른 언어의 actor 개념은 들어오고 나가는 메일 박스 기능과 비슷하지만 코틀린에서는 들어오는 메일 박스 기능만한다고 볼 수 있음.
* actor는 한 번에 1개의 메시지만 처리한는 것을 보장함. 이 코드느 특정 루프를 만들고 isClosedForReceive로 닫힌 상태가
* 아니라면 receive()를 사용해 desc를 반복 출력하도록 했음. 만일 채널이 닫히게 되면 ClosedSendChannelEexception을
* 만나게됨
* */

suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 100
    val time = measureTimeMillis {
        val jobs = List(n) {
            launch { repeat(k) { action() } }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

//counterActor를 위한 메시지
sealed class CounterMsg
object IncCounter : CounterMsg() // counter를 증가하기 위한 단방향 메시지
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg() // 응답 요청

// 새로운 counter actor를 위한 함수
fun CoroutineScope.counterActor() = actor<CounterMsg> {
    var counter = 0 //카운터
    for (msg in channel) { //들어오는 메시지에 대한 처리 반복문
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}

fun main() = runBlocking<Unit> {
    val counter = counterActor() //actor의 생성
    GlobalScope.massiveRun {
        counter.send(IncCounter)
    }

    //actor의 카운터 값을 얻기 위해 요청
    val response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))
    println("Counter = ${response.await()}")
    counter.close() //actor의 중단
}

/*
 * 위 프로그램은 함수로 쓰인 actor 블록을 생성하고 실행함. actor는 코루틴이고 순차적으로 실행되며 각 특정 actor 코루틴에
 * 한정되므로 공유된 변경 가능한 상태에도 문제가 없음. 이 방법은 lock 기법보다 유용한데 문맥 전환이 업기 때문임.
 * 들어오는 메시지 msg는 CounterMsg 자료형임. 만일 IncCounter가 사용되면 counter 상태를 증가시킴.
 * actor는 어떤 특정 상태를 관리하기 위한 백그라운드 태스크에 유용함.
 * */