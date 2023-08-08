package chap04.if_when

import java.lang.Integer.parseInt

/***
 * when (인자) {
 *   인자에 일치하는 값 혹은 표현식 -> 수행할 문장
 *   인자에 일치하는 범위 -> 수행할 문장
 *   ...
 *   else -> 수행할 문장
 * }
 */

fun main() {

    //1. 입력된 값이 1 또는 2일 때 처리함
    var x = readLine()!!.toInt()
    when (x) {
        1 -> println("x==1")
        2 -> println("x==2")
        else -> {
            println("x는 1, 2가 아닙니다.")
        }
    }

    //2. 조건 묶기
    when (x) {
        1, 2 -> println("x는 1 또는 2 입니다.")
        else -> println("x는 1 또는 2가 아닙니다.")
    }

    //3. 비교하는 변수의 타입이 다를 경우
    var s = "2"
    when (x) {
        //x값과 문자열 s값이 일치하면 아래 문장을 실행함
        parseInt(s) -> println("일치함")

        else -> println("불일치함")
    }

    //4. in 키워드 사용
    when (x) {
        in 1..10 -> println("x는 1 이상 10 이하입니다.")
        //10보다 작거나 20보다 큰 값
        !in 10..20 -> println("x는 10이상 20 이하의 범위에 포함되지 않습니다.")
        else -> println("x는 어떤 범위에도 없습니다.")
    }

    //5. 등급 계산
    print("Enter the score: ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    when (score) {
        in 90.0..100.0 -> grade = 'A'
        in 80.0..89.9 -> grade = 'B'
        in 70.0..79.9 -> grade = 'C'
        !in 70.0..100.0 -> grade = 'F'
    }
    println("Score: $score, Grade: $grade")

    //6. 인자 없는 when
    when {
        score >= 90.0 -> grade = 'A'
        score in 80.0..89.9 -> grade = 'B'
        score in 70.0..79.9 -> grade = 'C'
        score !in 70.0..100.0 -> grade = 'F'
    }
    println("Score: $score, Grade: $grade")

}