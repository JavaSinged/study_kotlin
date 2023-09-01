package main.java.chap07.moreClass

/*
* 실드 클래스
* - 미리 만들어 놓은 자료형들을 묶어서 제공함. 열거형 클래스의 확장으로 볼 수 있음.
* - 추상 클래스와 같기 때문에 객체를 만들 수 없음
* - 다른 파일에서는 상속이 불가능하게 제한됨.
* - 블록 안에 선언되는 클래스는 상속이 필요한 경우 open 키워드로 선언될 수 있음.
* */

// 첫 번째 실드 클래스 선언 방법
sealed class Result1 {
    open class Success(val message: String) : Result1()
    class Error(val code: Int, val message: String) : Result1()
}

class Status1 : Result1() //실드 클래스 상속은 같은 파일에서만 가능
class Inside1 : Result1.Success("Status") //내부 클래스 상속

// 첫 번째 실드 클래스 선언 방법
sealed class Result2

open class Success(val message: String) : Result2()
class Error(val code: Int, val message: String) : Result2()

class Status2 : Result2()
class Inside2 : Success("Status")

fun main() {
    //Success에 대한 객체 생성
    val result = Result1.Success("Good!")
    val msg = eval(result)
    println(msg)
}

//상태를 검사하기 위한 함수
fun eval(result: Result1): String = when(result){
    is Status1 -> "in progress"
    is Result1.Success -> result.message
    is Result1.Error -> result.message
}