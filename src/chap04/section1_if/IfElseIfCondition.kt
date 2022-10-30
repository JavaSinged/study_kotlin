package chap04.section1_if

fun main() {
    print("Enter teh score: ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    if (score >= 90.0){
        grade = 'A'
    } else if (score >= 80.0 && score <= 89.9 ) {
        grade = 'B'
    } else if (score >= 70.0 && score <= 79.9) {
        grade = 'C'
    }

    //변수 in 범위..범위 로 처리하기
    if (score >= 90.0){
        grade = 'A'
    } else if (score in 80.0..89.9) {
        grade = 'B'
    } else if (score in 70.0..79.9) {
        grade = 'C'
    }

    println("Score: $score, Grade: $grade")
}