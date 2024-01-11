package main.java.chap11.Coroutine

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
* channel은 자료를 서로 주고받기 위해 약속된 일종의 통로 역할을 함.
* 코루틴의 채널은 넌블로킹 전송 개념으로 사용되고 있음.
* 채널을 구현할 때는 SendChannel과 ReceiveChannel 인터페이스를 이용해 값들의 스트림을 전송하는 방법을 제공함.
* 실제 전송에는 다음과 같이 지연 함수 send()와 receive() 함수를 사용함
*
* - SendChannel의 suspend fun send(element:E)
* - ReceiveChannel의 suspend fun receive(): E
* */

fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        //여기에 다량의 CPU연산 작업이나 비동기 로직을 둘 수 있음
        for (x in 1..5) channel.send(x * x)
        channel.close() //모두 보내고 닫기 명시
    }
    repeat(5) { println(channel.receive()) } //5개의 값을 채널로부터 받음
    for (element in channel) println(element) //for문을 사용해 끝까지 읽기

    println("Done!")
}

/*
* 보내는 쪽과 받는 쪽에 몇 가지 중요한 상태가 있음.
* 송신자는 SendChannel에서 채널이 꽉 차있는지, 즉 isFull 값이 true인지 살펴보고 꽉 차 있으면 일시 지연됨.
* 만일 closse()에 의해 닫으면 isClosedForSend가 true로 지정되어 isFull은 false를 반환할 수 있음.
* 수신자는 isEmpty가 true라면 비어 있으므로 가져갈 게 없는 루틴은 일시 지연됨.
* 마찬가지로 닫을 경우 isClossedForReceive에 의해 false를 반환할 수 있음.
* 그 밖의 SendChannel과 ReceiveChannel에는 다음과 같은 메서드를 사용할 수 있음.
*
* - SendChannel.offer(element: E): Boolean // 가능하면 요소를 채널에 추가. 채널이 꽉찬 경우 false를 반환
* - ReceiveChannel.poll(): E? // 요소를 반환. 채널이 비어 있으면 null을 반환
* */