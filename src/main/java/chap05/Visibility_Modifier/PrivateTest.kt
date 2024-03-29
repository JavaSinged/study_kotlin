package chap05.Visibility_Modifier

//private 가시성 확인

private class PrivateClass{
    private var i = 1
    private fun privateFunc(){
        i+=1 // 접근 허용
    }
    fun access(){
        privateFunc() // 접근 허용
    }
}

class OtherClass {
//    val opc = PrivateClass() < 프로퍼티 객체 지정 불가 private로 선언해야함

    fun test(){
        val pc = PrivateClass() // 생성 가능
    }
}

fun main() {
    val pc = PrivateClass()

//    pc.i < 접근 불가
//    pc.privateFunc() < 접근 불가
}

fun TopFunction(){
    val tpc = PrivateClass() // 객체 생성 가능
}