package chap03.lambda

//일반 함수
fun _sum(a: Int, b: Int) = a + b
fun text(a: String, b: String) = "Hi! $a $b"

/***
 * a와 b를 가지고 받아와서 return c를 만나면 _sum함수가 호출되어서
 * 인자를 넘겨주고 5가 반환됨
 */
fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

/***
 * hello함수 선언부의 body함수와 함수에 인자로 전달한 2개의 문자열이 hi!와 결합되어 출력됩니다.
 */
fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}

fun main() {
    // 1. 인자와 반환값이 있는 함수
    val res1 = funcParam(3, 2, ::_sum)
    println(res1)

    // 2. 인자가 없는 함수
    hello(::text)

    // 3. 일반 변수에 값처럼 할당
    val likeLambda = ::sum
    println(likeLambda(6, 6))
}