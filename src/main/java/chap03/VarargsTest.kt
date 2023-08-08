package chap03

//vararg 키워드를 이용해서 가변인자로 함수 생성 가능
fun normalVarargs(vararg counts: Int) {
    for (num in counts) {
        print("$num ")
    }
    println()
}

fun main() {
    normalVarargs(1, 2, 3, 4)
    normalVarargs(4, 5, 6)

}