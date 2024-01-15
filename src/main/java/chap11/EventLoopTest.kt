package main.java.chap11

/*
* 이벤트 루프란 라이브러리를 통해 이벤트 처리를 위한 프로그래밍 모델을 만들기 위한 것
* 이벤트 루프는 각 이벤트 요청에 대한 이벤트 큐를 가지며 이벤트 큐는 이벤트 루프에 의해 처리할 핸들러인 작업자 스레드가
* 결정되어 실행됨. 이벤트 큐의 실행이 끝나면 이벤트 루프에 의해 다시 이벤트 큐의 위치로 돌아감.
* */

import kotlinx.coroutines.runBlocking

private const val PRINT_STR_ITEM = 1
private const val EXIT_ITEM = 2

fun main() = runBlocking {
    var evtLoopRunning = true

    while (evtLoopRunning) {
        println("-- Menu --")
        println("1. Print String")
        println("2. Exit")
        print("\nEnter number: ")
        evtLoopRunning = handleMenuInput()
    }
}

private fun printString() {
    var str = ""

    while (str.isEmpty()) {
        print("\nEnter String to print: ")
        str = readLine() ?: ""
        if (str.isNotEmpty()) println("You entered the following String: $str")
    }
}

private fun handleMenuInput() = when (readLine()) {
    PRINT_STR_ITEM.toString() -> {
        printString()
        true
    }

    EXIT_ITEM.toString() -> false
    else -> true
}