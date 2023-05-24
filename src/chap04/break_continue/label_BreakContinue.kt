package chap04.break_continue

fun labelBreak1(){
    println("labelBreak")
    for (i in 1..5){
        second@ for (j in 1..5){
            if (j == 3) break
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}

fun labelBreak2(){
    println("labelBreak")
    first@ for (i in 1..5){
        second@ for (j in 1..5){
            if (j == 3) break@first
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}

fun labelBreak3(){
    println("labelBreak")
    first@ for (i in 1..5){
        second@ for (j in 1..5){
            if (j == 3) continue@first
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}

fun main() {
    labelBreak1()
    println()
    labelBreak2()
    println()
    labelBreak3()
}