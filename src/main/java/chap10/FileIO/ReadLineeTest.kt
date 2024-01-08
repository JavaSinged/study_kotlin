package main.java.chap10.FileIO

/*
* 표준 입출력의 기본개념
* - 입력과 출력은 프로그래밍의 세계에서 빈번하게 일어나는 활동임.
* - print()와 println()은 내부적으로는 표준 출력 라이브러리인 자바의 System.out.println()을 호출함.
* */

fun main() {
    print("Enter: ")
    val input = readLine()!!
    println("You entered: $input")
}

/*
* 입력에 실패할 경우 null가능성이 생기기 때문에 !!혹은 ?를 사용해 NPE 발생 여부를 처리함.
* 입력받은 값들은 문자열 값이 기본이기 때문에 입력 직후 정수형으로 변환하려면 readLine()!!.toInt() 형태로 호출할 수 있음.
* */