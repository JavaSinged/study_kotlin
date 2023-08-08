package chap04.break_continue

fun main() {
    println("break exam")
    for (i in 1..5){
        if (i == 3 )break
        print(i)
    }
    println()
    println("outside")

    println("continue exam")
    for (i in 1..5){
        if (i == 3 )continue
        print(i)
    }
    println()
    println("outside")
}