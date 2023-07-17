package chap05

open class Car protected constructor(_year: Int, _model: String, _power: String, _wheel: String) {
    private var year: Int = _year
    public var model: String = _model
    protected open var power: String = _power
    internal var wheel: String = _wheel

    protected fun start(key: Boolean) {
        if (key) println("Start the Engine!")
    }

    class Driver(_name: String, _license: String) {
        private var name: String = _name
        var license: String = _license
        internal fun driving() = println("[Driver] Driving() - $name")
    }
}

class Tico(_year: Int, _model: String, _power: String, _wheel: String, var name: String, private var key: Boolean) :
    Car(_year, _model, _power, _wheel) {
    override var power: String = "50hp"
    val driver = Driver(name, "first class")

    constructor(_name: String, _key: Boolean) : this(2014, "basic", "100hp", "nomal", _name, _key) {
        name = _name
        key = _key
    }

    fun access(password: String){
        if (password == "gotico"){
            println("----[Tico] access()---------")
//            super.year < private 접근 불가
            println("super.model = ${super.model}")
            println("super.power = ${super.power}")
            println("super.whell = ${super.wheel}")
            super.start(key)

//            driver.name < private 접근 불가
            println("Driver().license = ${driver.license}")
            driver.driving()
        }else{
            println("You're a burglar")
        }
    }
}

class Burglar(){
    fun steal(anycar: Any){
        if (anycar is Tico){
            println("----[Burglar] steal()---------")
//            println(anycar.power) < protected 접근 불가
//            println(anycar.year) < private 접근 불가
            println("anycar.name = ${anycar.name}")
            println("anycar.wheel = ${anycar.wheel}")
            println("anycar.model = ${anycar.model}")

            println(anycar.driver.license)
            anycar.driver.driving()
//            println(Car.start) < protected 접근 불가
            anycar.access("dontknow")
        }else{
            println("Nothing to steal")
        }
    }
}

fun main() {
//    val car = Car() < protected 생성 불가
    val tico = Tico("kildong", true)
    tico.access("gotico")

    val burglar = Burglar()
    burglar.steal(tico)
}