package chap05.openClass

open class Bird2(var name: String, var wing: Int, var beak: String, var color: String) {
    fun fly() = println("Fly wing:$wing")
    open fun sing(vol: Int) = println("Sing vol:$vol")
}

class Parrot2(name: String, wing: Int = 2, beak: String, color: String, var language: String = "natural") :
    Bird2(name, wing, beak, color) {
    fun speak() = println("Speak! $language")
    override fun sing(vol: Int) {
        println("I'm a parrot! The volume level is $vol")
        speak()
    }
}

fun main() {
    val parrot2 = Parrot2(name = "myparrot", beak = "short", color = "multiple")
    parrot2.language = "English"

    println("Parrot2: ${parrot2.name}, ${parrot2.wing}, ${parrot2.beak},${parrot2.color}, ${parrot2.language}")
    parrot2.sing(5)
}