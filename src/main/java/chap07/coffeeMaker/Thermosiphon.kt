package main.java.chap07.coffeeMaker

class Thermosiphon(heater: Heater): Pump, Heater by heater { //위임 사용
    override fun pump() {
        if (isHot()){
            println("[Thermosiphon] pumping...")
        }
    }
}