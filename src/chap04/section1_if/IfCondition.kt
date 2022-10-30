package chap04.section1_if

fun main() {
    val a = 12
    val b = 7

    val max = if (a>b){
        println("a 선택")
        a //max에 할당되는 변수
    } else {
        println("b 선택")
        b //max에 할당되는 변수
    }

    println(max)
}