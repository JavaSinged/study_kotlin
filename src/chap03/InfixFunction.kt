package chap03

fun main() {
    //일반 표현법
    val multi1 = 3.multiply(10)

    //중위 표현법
    val multi2 = 3 multiply 10
    println("multi: $multi2")
}

infix fun Int.multiply(x:Int): Int{
    return this * x
}