package chap04.section1_if

fun main() {
    print("Enter the score: ")
    var score = readLine()!!.toDouble()
    var grade: Char = 'F'

    //μΈμ μλ when
    when {
        score >= 90.0 -> grade = 'A'
        score in 80.0..89.9 -> grade = 'B'
        score in 70.0..79.9 -> grade = 'C'
        score < 70.0 -> grade = 'F'
    }

    println("Score: $score, Grade: $grade")
}