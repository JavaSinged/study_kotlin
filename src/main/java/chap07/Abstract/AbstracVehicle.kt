package main.java.chap07.Abstract

/*
* 추상클래스 Abstract Class
* - 선언 등의 대략적인 설계 명세와 공통의 기능을 구현한 클래스
* - abstrct 키워드로 선언함
* - 추상 클래스를 상속하는 하위 클래스가 어떻게 만들어야 하는지를 나타내는 용도로 사용됨
* - 멤버인 프로퍼티나 메서드도 abstract로 선언될 수 있음
* */

abstract class Vehicle(val name: String, val color: String, val weight: Double) {

    //추상 프로퍼티 : 반드시 하위 클래스에서 재정의해 초기화해야 함
    abstract var maxSpeed: Double

    //일반 프로퍼티
    var year = "2018"

    //추상 메서드 : 반드시 하위 클래스에서 구현해야함
    abstract fun start()
    abstract fun stop()

    //일반 메서드
    fun displaySpecs() {
        println("Name: $name, Color: $color, Weight: $weight, Year: $year, MaxSpeed: $maxSpeed")
    }
}

class Car(name: String, color: String, weight: Double, override var maxSpeed: Double) : Vehicle(name, color, weight) {
    override fun start() {
        println("Car Started")
    }

    override fun stop() {
        println("Car Stopped")
    }
}

class Motorcycle(name: String, color: String, weight: Double, override var maxSpeed: Double) :
    Vehicle(name, color, weight) {
    override fun start() {
        println("Bike Started")
    }

    override fun stop() {
        println("Bike Stopped")
    }
}

fun main() {
    val car = Car("SuperMatiz", "yellow", 1110.0, 270.0)
    val motor = Motorcycle("DreamBike", "red", 173.0, 100.0)

    car.year = "2013"

    car.displaySpecs()
    car.start()
    motor.displaySpecs()
    motor.start()

    car.stop()
    motor.stop()

}