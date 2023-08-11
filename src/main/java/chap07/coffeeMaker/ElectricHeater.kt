package main.java.chap07.coffeeMaker

class ElectricHeater(var heating: Boolean = false) : Heater {
    override fun on() {
        println("[ElectricHeater] heating...")
    }

    override fun off() {
        heating = false
    }

    override fun isHot(): Boolean = heating
}