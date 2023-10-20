package main.java.chap08.Generic

/*
fun <T> add(a:T, b:T): T{
    return a + b //자료형을 아직 결정할 수 없음
}
*/

fun <T> add(a:T, b:T, op: (T,T) -> T): T{
    return op(a, b) //람다식으로 변환
}

fun main() {
    val result = add(2,3, {a,b -> a+b})
    val res = add(2,3) {a,b -> a+b}

    println(result)
    println(res)
}