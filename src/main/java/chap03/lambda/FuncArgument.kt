package chap03.lambda

fun sum(a: Int, b: Int) = a + b
fun mul(a: Int, b: Int) = a * b

fun funcFunc():Int{
    return sum(2,2)
}

fun main() {
    val res1 = sum(3, 2)
    val res2 = mul(sum(3, 3), 3)

    println(res1)
    println(res2)

    println("funcFunc: ${funcFunc()}")
}