package chap03

inline fun shortFunc2(a:Int, noinline out:(Int)->Unit){
    println("Before calling out()")
    out(a)
    println("After calling out()")
}

fun main() {
    shortFunc2(3){ println("First call: $it") }
}