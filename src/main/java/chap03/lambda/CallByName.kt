package chap03.lambda

/***
 * main 함수에서 callByName함수가 실행되고
 * 'return b()'가 실행되면 otherLambda함수가 실행됨
 */
fun callByName(b: () -> Boolean): Boolean {
    println("callByName function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}

fun main() {
    val result = callByName(otherLambda)
    println(result)
}