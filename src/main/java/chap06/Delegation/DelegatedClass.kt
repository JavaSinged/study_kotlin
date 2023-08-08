package main.java.chap06.Delegation

/*
* by
* - 프로퍼티를 위임할 때 사용하는 키워드
* - 주로 상속을 허용하지 않는 클래스에서 새로운 기능을 추가할 때 사용함
* 사용법 : < val | var | class > 프로퍼티 혹은 클래스 이름 : 자료형 by 위임자
*
* lazy
* - lazy 람다식은 람다식을 전달받아 저장한 Lazy<T> 인스턴스를 반환함
* - 최초 프로퍼티의 게터 실행은 lazy에 넘겨진 람다식을 실행하고 결과를 기록함
* - 이후 프로퍼티의 게터 실행은 이미 초기화되어 기록된 값을 반환함
* - by lazy에 의한 지연 초기화는 스레드에 좀 더 안정적으로 프로퍼티를 사용할 수 있음
* */

interface Car {
    fun go(): String
}

class VanImpl(val power: String) : Car {
    override fun go(): String = "은 짐을 적재하며 ${power}을 가집니다."
}

class SportImpl(val power: String) : Car {
    override fun go(): String = "은 경주용에 사용되며 ${power}을 가집니다."
}

class CarModel(val model: String, impl: Car) : Car by impl{
    fun carInfo(){
        println("$model ${go()}")
    }
}

fun main() {
    val myDamas = CarModel("Damas 2010", VanImpl("100마력"))
    val my350z = CarModel("350Z 2008", SportImpl("350마력"))

    myDamas.carInfo()
    my350z.carInfo()
}