package chap03

/***
 * 재귀함수의 조건
 *  - 무한 호출에 빠지지 않도록 탈출 조건을 만들어 둔다.
 *  - 스택 영역을 이용하므로 호출 횟수를 무리하게 많이 지정해 연산하지 않는다.
 *  - 코드를 복잡하지 않게 한다.
 */

fun factorial(n: Int): Long {
    return if (n == 1) n.toLong() else n * factorial(n - 1)
}

tailrec fun factorial2(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else factorial2(n - 1, run * n)
}

fun main() {
    var number = 4
    val result: Long

    result = factorial(number)
    println("Factorial: $number->$result")

    number = 5
    println("Factorial: $number -> ${factorial2(number)}")

}