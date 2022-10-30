package chap02

fun main() {
    var str1 : String? = "Hello Kotlin" //null 값이 들어올 수 있을 땐 '?'를 사용하여 처리
    str1 = null
    println("str1:$str1, length: ${str1?.length}")


}