package chap03

/***
 * 중위함수의 조건
 *  - 멤버 메서드 또는 확장 함수여야 한다.
 *  - 하나의 매개변수를 가져야 한다.
 *  - infix 키워드를 사용하여 정의한다.
 */
infix fun Int.multiply(x:Int):Int{
    return this*x
}

fun main() {
    //일반 표현법
    val multi1 = 3.multiply(10)

    //중위 표현법 [일반 표현법보다 직관적임]
    val multi2 = 3 multiply 10

    println(multi1)
    println(multi2)

}