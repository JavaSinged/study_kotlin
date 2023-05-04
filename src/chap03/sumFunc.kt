package chap03

fun sum(a:Int, b:Int):Int{
    val sum = a+b
    return sum
}

fun max(a:Int, b: Int) = if (a>b) a else b

fun printSum(a: Int, b: Int): Unit{
    println("sum of $a and $b is ${a+b}")
}

fun main() {
    val result1 = sum(3,2)
    val result2 = sum(6, 7)

    val num1 = 10
    val num2 = 3

    //반환 값이 없는 함수
    printSum(3, 4)

    println(result1)
    println(result2)
    println(max(num1, num2))

}