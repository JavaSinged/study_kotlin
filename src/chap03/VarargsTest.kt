package chap03

fun main() {
    normalVarargs(1, 2, 3, 4)
    normalVarargs(4, 5, 6)

}

fun normalVarargs(vararg count: Int) { //varaargs : 가변인자
    for (num in count) {
        print("$num")
    }
    println()
}