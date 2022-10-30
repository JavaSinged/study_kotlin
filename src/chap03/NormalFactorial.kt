package chap03

fun main() {
    val number = 4
    var result: Long

    result = factorial1(number)
    println("Factorial: $number -> $result")

    result = factorial2(number)
    println("Factorial: $number -> $result")
}

//일반 재귀 함수
fun factorial1(n:Int):Long{
    return if(n==1) n.toLong() else n * factorial1(n-1)
}

//꼬리 재귀 사용
tailrec fun factorial2(n:Int, run:Int = 1):Long{
    return if(n==1) run.toLong() else factorial2(n-1, run*n)
}