package main.java.chap07.moreClass

/*
* inner 클래스의 바깥 클래스의 멤버 접근
* 이너 클래스인 ExternalStorage는 Samartphone 클래스의 프로퍼티 model과 cpu에 접근하고 있다.
* 특히 cpu는 private 멤버이지만 접근이 가능한 것을 알 수 있다.
*/

interface Switcher {
    fun on(): String
}

class Smartphone(val model: String) {
    private val cpu = "Exynos"

    inner class ExternalStorage(val size: Int) {
        fun getInfo() = "${model}: Installed on $cpu with ${size}Gb"
    }

    //지역 클래스 추가
    fun powerOn(): String {
        class Led(val color: String) {
            fun blink(): String = "Blinking $color on $model"
        }

        val powerStatus = Led("Red") // 지역 클래스 사용 부분
        val powerSwitch = object : Switcher {
            // 익명 객체를 사용해 Switcher의 on()을 구현
            override fun on(): String {
                return powerStatus.blink()
            }

        }
        return powerSwitch.on()
    }
}

fun main() {
    val mySdcard = Smartphone("S7").ExternalStorage(32)
    println(mySdcard.getInfo())

    val myPhone = Smartphone("Note9")
    myPhone.ExternalStorage(128)
    println(myPhone.powerOn())
}