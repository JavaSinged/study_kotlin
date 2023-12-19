package main.java.chap10.StandardLibrary

/*
* let() 함수는 함수를 호출하는 객체 T를 이어지는 block의 인자로 넘기고 block의 결과값 R을 반환함.
* let() 함수는 제네릭 확장 함수 형태이므로 어딛든 적용할 수 있음.
* 매개변수로는 람다식 형태인 block이 있고 T를 매개변수로 받아 R을 반환함.
* 이 함수를 호출한 객체를 인자로 받으므로 이를 사용하여 다른 메서드를 실행하거나 연산을 수행해야 하는 경우 사용할 수 있음.
* */
fun main() {
    val score: Int? = 32
    //var score = null

    //일반적인 null 검사
    fun checkScore() {
        if (score != null) {
            println("Score: $score")
        }
    }

    //let() 함수를 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") } // 1
        val str = score.let { it.toString() } // 2
        println(str)
    }

    checkScore()
    checkScoreLet()

    /*
    * score는 null 가능성이 있는 변수로 선언되었기 때문에 cheeckScore()에서 if문을 사용해 null 검사를 하고 있음.
    * 1의 checkScoreLet()을 보면 score에 멤버 메서드를 호출하듯 let()함수를 사용했는데 매개변수가 람다식 하나일 때는
    * let({..})에서 표현ㅇ이 소괄호가 생략되어 let{...}과 같이 작성할 수 있음. 그리고 score?.처럼 null에 안전한 호출을
    * 위해 세이프콜(?.)을 사용했음. 만일 score가 null일 경우 람닫식 구문은 수행되지 않음.
    * 2을 보면 toString()을 사용해 it을 문자열로 변환한 후 반환된 값을 str에 할당함.
    * 이때 세이프콜을 사용하지 않았음. 만일 score가 nulldlfkaus str에는 null이 할당됨. 세이프콜을 사용하더라돋 람다식을
    * 사용하지 않게 되므로 str은 String?으로 추론되어 null이 할당됨.
    * */

    //메서드 체이닝
    var a = 1
    var b = 2

    a = a.let { it + 2 }.let {
        val i = it + b
        i //마지막 식 반환
    }
    println(a)
}

