package chap04

fun main() {
    print("Enter the score: ")
    //사용자 입력 !!은 non-null 단정 기호롤 null인 경우 예외처리를 해줘야할 수 있음.
    val score = readLine()!!.toDouble()
    var grade:Char = 'F'

    if (score>=90.0){
        grade = 'A'
    }else if (score >=80.0 && score <= 89.9){
        grade = 'B'
    }else if (score >= 70.0 && score <= 79.9){
        grade = 'C'
    }

    println("Score : $score, Grade: $grade")
}