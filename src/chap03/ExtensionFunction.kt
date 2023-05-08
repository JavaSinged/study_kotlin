package chap03

/***
 * 확장함수 정의 방법
 * fun 확장대상.함수_이름(매개변수, ...): 반환값 {
 *      ...
 *      return 값
 * }
 */
//String 객체에 getLongStirng 확장함수를 추가
fun String.getLongString(target: String): String =
    if (this.length > target.length) this else target

fun main() {
    val source = "Hello Wolrd"
    val target = "Kotlin"
    println(source.getLongString(target))
}