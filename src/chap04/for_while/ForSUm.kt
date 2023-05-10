package chap04.for_while

/***
 * for ( 요소 변수 in 컬렉션 또는 범위 ) { 반복할 본문 }
 */

fun main() {
    for (x in 1..5) println(x)

    //상행 반복
    var sum = 0
    for (x in 1..10) sum += x
    println("sum: $sum")

    //하행 반복
    for (i in 5 downTo 1) print(i)
    println()

    //step 키워드
    for (i in 1..5 step 2) print(i)
    println()
    for (i in 5 downTo 1 step 2) print(i)
}