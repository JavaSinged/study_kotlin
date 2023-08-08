package chap05.Relationship

/*
* 구성(Composition) 관계
* - 집합 관계와 유사하지만 특정 클래스가 어느 한 클래스의 부분이 되는 것
* - 구성품으로 지정된 클래스는 생명주기가 소유자 클래스에 의존됨
* - 소유자 클래스가 삭제되면 구성하고 있던 클래스도 삭제됨
* */

class Car(val name:String,  val power: String){
    private var engine = Engine(power)

    fun startEngine() = engine.start()
    fun stopEngine() = engine.stop()
}

class Engine(power: String) {
    fun start() = println("Engine has been started")
    fun stop() = println("Engine has been stopped")
}

fun main() {
    val car = Car("tico", "100hp")
    car.startEngine()
    car.stopEngine()
}
