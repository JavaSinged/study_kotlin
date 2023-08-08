package chap03

inline fun shortFunc3(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out()")
}

fun main() {
    shortFunc3(3) {
        println("First call: $it")
        return
    }
}