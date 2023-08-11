package main.java.chap07.coffeeMaker

class MyDripCoffeeModule : CoffeeModule {

    companion object {
        val electricHeater: ElectricHeater by lazy { // laze를 이용한 지연 초기화
            ElectricHeater()
        }
    }

    private val _thermosiphone: Thermosiphon by lazy { // 임시적인 private 프로퍼티
        Thermosiphon(electricHeater)
    }

    override fun getThermosiphon(): Thermosiphon = _thermosiphone
}

/*
* by lazy를 사용해 ElectricHeater와 Thermosiphon이 접근되는 시점에 초기화하도록 함
* Thermosiphon으로 초기화하기 위해 임시 프로퍼티인 _thermosiphon을 사용해 private으로 선언함
* - 외부에서 초기화하지 못하고 오직 클래스 내보의 getThermosiphon()에 의해서만 초기화되도록 설계
* */