package main.java.chap11.Coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select
import java.util.Random

//다양한 채널에서 무언가 응답해야 한다면 각 채널의 실행 시간에 따라 결과가 달라질 수 있는데 이때 select를 사용하면 표현식을 통해 결과를 받을 수 있음.
fun main() = runBlocking{
    val routine1 = GlobalScope.produce {
        delay(Random().nextInt(1000).toLong())
        send("A")
    }
    val routine2 = GlobalScope.produce {
        delay(Random().nextInt(1000).toLong())
        send("B")
    }
    val result = select<String> {
        routine1.onReceive{result -> result}
        routine2.onReceive{result -> result}
    }
    println("Ressult was $result")
}

/*
* produce로 만든 2개의 루틴은 무작위로 지정된 시간에 각각 A, B라는 문자열을 채널에 보내게 됨.
* 이때 select 블록의 onReceive를 통해 채널로부터 이 값을 받아 먼저 완성된 결과를 가져오게 됨.
* */