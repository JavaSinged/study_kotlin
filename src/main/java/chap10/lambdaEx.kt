package main.java.chap10

fun main() {
    //val 변수 이름 : 자료형 선언 = { 매개변수[,...] -> 람다식 본문 }

    /*
    * sum은 익명 함수로 만들어지며 매개변수는 선언부의 자료형에 의해 (Int, Int)를 가지게 됨.
    * 반환값은 Int이므로 람다식의 x + y가 반환됨.
    * */
    val sum: (Int, Int) -> Int = { x, y -> x + y }

    /*
    * mul은 변수의 자료형 표기가 생략되었지만 람다식에 있는 매개변수의 Int선언 표현에 의해 반환 자료형을
    * (Int, Int) -> Int로 추론할 수 있음
    * */
    val mul = { x: Int, y: Int -> x * y }

    //매개변수가 1개인 경우, 매개변수를 생략하고 it으로 표기할 수 있음
    val add: (Int) -> Int = { it + 1 }

    //출론된 반환 자료형이 Unit이 아닌 경우에는 본문의 마지막 표현식이 반환값으로 처리됨
    val isPositive: (Int) -> Boolean = {
        val isPositive = it > 0
        isPositive //마지막 표현식이 반환됨
    }

    //특정 라벨을 지정해 반환할 수 있음. return@라벨이름 형태로 지정할 수 있음
    val isPositiveLabel: (Int) -> Boolean = number@{
        val isPositive = it > 0
        return@number isPositive //라벨을 사용해 반환됨
    }

    //고차 함수 : 함수의 매개변수로 함수를 받거나 함수 자체를 반환할 수 있는 함수
    fun inc(x: Int): Int {
        return x + 1
    }

    fun high(name: String, body: (Int) -> Int): Int {
        println("name: $name")
        val x = 0
        return body(x)
    }

    //함수를 이용한 람다식
    val result1 = high("Sean", { x -> inc(x + 3) })

    //소괄호 바깥으로 빼내고 생략
    val result2 = high("Sean") { inc(it + 3) }

    //매개변수 없이 함수의 이름만 사용할 때
    val result3 = high("Kim", ::inc)

    //람다식 자체를 넘겨준 형태
    val result4 = high("Sean") { x -> x + 3 }

    //매개변수가 1개인 경우 생략
    val result5 = high("Sean") { it + 3 }

    println(result1)
    println(result2)
    println(result3)
    println(result4)
    println(result5)
}