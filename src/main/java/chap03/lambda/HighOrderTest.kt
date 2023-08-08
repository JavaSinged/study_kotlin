package chap03.lambda

fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}

fun main() {
    var result: Int
    val multi = { x: Int, y: Int -> x * y }
    result = multi(10, 20)

    println(result)

    result = highOrder({ x, y -> x + y }, 10, 20)
    println(result)

    val out:()->Unit = { println("Hello World!") }

    out()
    val new = out
    new()
}