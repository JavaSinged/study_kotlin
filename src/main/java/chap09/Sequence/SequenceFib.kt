package main.java.chap09.Sequence

fun main() {
    //시퀀스를 이용한 피보나치 수열 출력하기
    val fibonacci = generateSequence(1 to 1){it.second to it.first + it.second}
        .map { it.first }
    println(fibonacci.take(10).toList())
}