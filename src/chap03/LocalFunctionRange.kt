package chap03

fun a() = b()
fun b() = println("b")

fun c(){
//    fun d() = e() < error
    fun e() = println("e")
}

fun main() {
    a()
    //e() < error
}