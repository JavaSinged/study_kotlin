package chap03

inline fun shortFunc4(a: Int, crossinline out: (Int) -> Unit) {
    println("Before calling out()")
    nestedFunc { out(a) }
    println("After calling out()")
}

fun nestedFunc(body: () -> Unit) {
    body()
}

fun main() {
    shortFunc4(3) {
        println("First call: $it")
        //return 사용 불가
    }
}