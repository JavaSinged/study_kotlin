package main.java.chap11.Concurrency

import main.java.chap11.Thread.thread

/*
* 자바의 volatile도 synchronized와 같은 방법으로 사용할 수 있음.
* 보통 변수는 성능 때문에 데이터를 캐시에 넣어 두고 작업하는데 이때 여러 스레드로부터 값을 읽거나 쓰면 데이터가 일치하지 않고 깨짐.
* 이것을 방지하기 위해 데이터를 캐시에 넣지 않도록 volatile 키워드와 함께 변수를 선언할 수 있음.
* 또 volatile 키워드를 사용하면 코드가 최적화되면서 순서가 바뀌는 경우도 방지할 수 있음.
* volatile을 사용하면 항상 프로그래머가 의도한 순서대로 읽기 및 쓰기를 수행함.
* 두 스레드에서 공유 변수에 대한 읽기와 쓰기 연산이 있으면 volatile 키워드만으로는 충분하지 않기때문에 synchronized를 통해
* 변수의 읽기 및 쓰기 연산의 원자성을 보장해 줘야함. 단, 한 스레드에서 volatile 변수의 값을 읽고 쓰고, 다른 스레드에서는
* 오직 volatile 변수의 값을 읽기만 할 경우, 읽는 스레드에서는 volatile 변수가 가장 최근에 쓰여졌다는 것을 보장함.
* */

@Volatile
private var running = false
private var count = 0

fun start() {
    running = true
    thread(start = true) {
        while (running) println("${Thread.currentThread()}, count: ${count++}")
    }
}

fun stop() {
    running = false
}

fun main() {
    start()
    start()
    Thread.sleep(10)
    stop() //여기서 상태를 바꿈
}