package chap05.Visibility_Modifier

//internal test : 패키지 이름이 다르면 import를 사용해야 클래스를 사용할 수 있음
fun main() {
    val otheric = InternalClass()

    println(otheric.i)
    otheric.icFunc()
}