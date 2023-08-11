package main.java.chap07.Interface

interface Bird {
    val wings: Int
    fun fly()
    fun jump() {
        println("bird jump")
    }
}

interface Horse {
    val maxSpeed: Int
    fun run()
    fun jump() {
        println("jump!, max speed: $maxSpeed")
    }
}

//여러 인터페이스를 이요한 다중 상속
class Pegasus : Bird, Horse {
    override val wings: Int = 2
    override fun fly() {
        println("Fly!")
    }

    override val maxSpeed: Int = 100

    override fun run() {
        println("Run!")
    }

    override fun jump() {
        super<Horse>.jump()
        println("Pegasus Jump!")
    }
}

fun main() {
    val pegasus = Pegasus()
    pegasus.fly()
    pegasus.run()
    pegasus.jump()
}