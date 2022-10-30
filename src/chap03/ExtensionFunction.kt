package chap03

fun main() {
    val source  = "Hello World!"
    val target = "Kotlin"
    println(source.getLongString(target))
}

//String 객체에 getLongString 메서드를 만듦
fun String.getLongString(target: String): String =
    if(this.length > target.length) this else target