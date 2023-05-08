package chap04

fun main() {
    val a = 12
    val b = 7

    //블록과 함께 사용
    val max = if (a>b){
        println("a 선택")
        a /* return 키워드 생략 */
    }
    else{
        println("b 선택")
        b /* return 키워드 생략 */
    }

    println(max)
}