package chap03

import java.math.BigInteger

/***
 * tailrec을 써서 꼬리재귀 함수로 만들게되면 기존의 재귀함수로는 2만번 이상 반복되는 재귀함수를 만들게되면
 * 스택 오버플로로 인한 오류를 막을 수 있음
 */

tailrec fun fibonacci(n:Int, a:BigInteger, b:BigInteger): BigInteger{
    return if (n == 0) a else fibonacci(n-1, b, a+b)
}

fun main() {
    val n = 100
    val first = BigInteger("0")
    val second = BigInteger("1")

    println(fibonacci(n, first, second))
}