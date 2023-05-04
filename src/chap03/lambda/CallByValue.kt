package chap03.lambda
/**
 * 18번 줄에서 lambda 함수가 먼저 실행이 되고, true 값을 반한한 뒤
 * callByValue 함수가 실행이 되고, true 값이 반한이 됨
 * 따라서 result 값은 true가 됨
 */


fun callByValue(b: Boolean): Boolean {
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {
    println("lambda function")
    true
}

fun main() {
    val result = callByValue(lambda())
    println(result)
}