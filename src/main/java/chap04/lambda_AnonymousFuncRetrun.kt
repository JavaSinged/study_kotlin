package chap04


/**
 * 익명 함수 방법으로 return을 하면 2개의 return이 확실히 구별됨
 * 보통의 경우는 lambda를 사용하고 retrun과 같이 명시적으로 반환해야할 것이 여러 개라면 익명 함수를 쓰는 것이 좋음
 */

fun main() {
    //람다식 방법
    val getMessage = lambda@{ num: Int ->
        if (num !in 1..100) {
            return@lambda "Error"
        }
        "Sucess"
    }

    //익명 함수 방법
    val getMessage2 = fun (num:Int):String{
        if (num !in 1..100) {
            return "Error"
        }
        return "Sucess"
    }

    println("lambda: ${getMessage(100)}")
    println("anonymous: ${getMessage2(100)}")
}