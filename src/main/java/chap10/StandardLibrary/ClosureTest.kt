package main.java.chap10.StandardLibrary

/*
* 람다식을 사용하다 보면 내부 함수에서 외부 변수를 호출하고 싶을 때가 있음.
* 클로저란 람다식으로 표현된 내부 함수에서 외부 범위에 선언된 변수에 접근할 수 있는 개념을 말함.
* 이때 람다식 안에 있는 외부 변수는 값을 유지하기 위해 람다식의 포획(Capture)한 변수라고 부름.
* 클로저 개념에서는 포획한 변수는 참조가 유지되어 함수가 종료되어도 사라지지 않고 함수의 변수에 접근하거나
* 수정할 수 있게 해줌.
*
* 클로저의 조건
* - final 변수를 포획한 경우 변수 값을 람다식과 함께 저장한다.
* - final이 아닌 변수를 포회기한 경우 변수를 특정 래퍼(wrapper)로 감싸서 나중에 변경하거나 읽을 수 있게 한다.
* 이때 래퍼에 대한 참조를 람다식과 함께 저장한다.
* */
class Calc {
    fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit) {
        add(a, b)
    }
}

fun main() {
    //클로저 테스트하기
    val calc = Calc()
    var result = 0 //외부의 변수
    calc.addNum(2, 3) { x, y -> result = x + y }//클로저
    println(result) //값을 유지하여 5 출력

    //길이가 일치하는 이름만 반환

    /*
    * filter는 ArrayLisst의 멤버 메서드로 람다식을 전달받고 있음.
    * 이때 length는 람다식 바깥의 변수로 인자로 입력받은 길이에 일치하는
    * 요소 목록을 반환해 filterResult에 저장 후 출력.
    * */
    fun filteredNames(lenght: Int){
        val names = arrayListOf("Kim", "Hong", "Go", "Hwang", "Jeon")
        val filterResult = names.filter {
            it.length == lenght //바깥의 length에 접근
        }
        println(filterResult)
    }
    filteredNames(4)
}