package chap04.section2_for

fun main() {
    var sum = 0

    for (x in 1..10) sum += x
    println("sum: $sum")
}