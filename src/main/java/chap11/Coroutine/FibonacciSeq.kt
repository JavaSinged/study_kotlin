package main.java.chap11.Coroutine

/*
* squence()를 사용하면 아주 많은 값을 만들어 내는 코드들로부터 특정 값의 범위를 가져올 수 있음.
* sequence()함수는 Sequence<T>를 반환하는데 Sequence() 함수 내부에서 지연 함수를 사용할 수 있고 코루틴과 함께
* 최종 형태를 나중에 결정할 수 있는 lazy 시퀀스를 만들 수도 있음.
* */

//sequence() 함수를 사용한 피보나치 수열
val fibonacciSeq = sequence {
    var a = 0
    var b = 1
    yield(1) //1, 지연 함수가 사용됨

    while (true) {
        yield(a + b) //2
        val tmp = a + b
        a = b
        b = tmp
    }
}

//generateSequence()의 사용
val seq = sequence {
    val start = 0
    //단일 값 산출
    yield(start)
    //반복 값 산출
    yieldAll(1..5 step 2)
    //무한한 시퀀스에서 산출
    yieldAll(generateSequence(8) { it * 3 })
}

fun main() {
    println(fibonacciSeq.take(8).toList()) //3, 8개의 값을 획득
    /*
    * 1번의 sequence 블록에서 지연 함수인 yield() 함수를 호출하면서 코루틴을 생성함
    * 2번의 while 루프는 매 단계를 무한하게 순회할 때 코루틴에서 다음 수를 계산하도록 실행됨
    * 3번에서 take().toList()에 의해 무한한 피보나치 수열 중 8개를 List로 변환해 화면상에 출력함.
    * 핵심은 yield()함수의 작동 방식임
    * 각 표현식을 계속 진행하기 전에 실행을 잠시 멈추고 요소를 반환함. (값을 산출한다고 말함)
    * 그리고 멈춘 시점에서 다시 실행을 재개함 (1, 2번은 작업이 일시 중단되었다가 다시 재개되는 부분임)
    * 3번에서 이렇게 가져온 데이터는 사실 일회성이기 떄문에 어딘가에 저장되어 있지 않고 단 한번 사용될 뿐임.
    * */

    println(seq.take(7).toList())

    //다음 요소에 대한 지정
    val saved = fibonacciSeq.iterator()
    println("${saved.next()}, ${saved.next()}, ${saved.next()}")
}

