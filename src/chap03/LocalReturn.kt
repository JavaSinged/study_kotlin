package chap03

fun main() {
    shortFunc3(3){
        println("First call : $it")
        return //비지역 반환 Non-local Return
    }
}

inline fun shortFunc3(a: Int, out: (Int)->Unit){
    println("Before calling out()")
    out(a)
    println("After calling out()")
}