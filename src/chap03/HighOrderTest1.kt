package chap03

fun main() {
    var result: Int
    val multi = { x: Int, y: Int -> x * y }
    result = multi(10, 20)
    println(result)

    val greet: () -> Unit = { println("Hello World") }
    val square: (Int) -> Int = { x -> x * x }

    greet() //매개변수 없는 람다식 호출
    println(square(3)) //매개변수가 하나인 매개변수 호출
}