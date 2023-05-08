package chap03

inline fun shortFunc(a:Int, out:(Int)->Unit){
    println("Before calling out()")
    out(a)
    println("After calling out()")
}

fun main() {
    shortFunc(3){ println("First call: $it") }
    shortFunc(5){ println("Second call: $it") }
}