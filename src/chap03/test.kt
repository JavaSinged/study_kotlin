package chap03

inline fun doSomething(action1 : () -> Unit, noinline action2 : () -> Unit){
    action1()
    anotherFunc(action2)
}

fun anotherFunc(action: () -> Unit){
    action()
}

fun main() {
    doSomething({ println("1")}, { println("2")})
}