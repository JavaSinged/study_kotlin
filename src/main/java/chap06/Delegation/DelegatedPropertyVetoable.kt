package main.java.chap06.Delegation

import kotlin.properties.Delegates

// vetoable 함수는 반환값에 따라 프로퍼티 변경을 허용하거나 취소할 수 있음

fun main() {
    var max: Int by Delegates.vetoable(0) { prop, old, new ->
        new > old
    }

    println(max)
    max = 10
    println(max)

    max = 5
    println(max)
}