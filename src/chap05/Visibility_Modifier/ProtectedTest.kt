package chap05.Visibility_Modifier

//protected 가시성 확인

open class Base{ // 최상위 선언 클래스에서 protected를 사용할 수 없음
    protected var i = 1
    protected fun protectedFunc(){
        i+=1 // 접근 허용
    }

    fun access(){
        protectedFunc() // 접근 허용
    }

    protected class Nested // 내부 클래스에는 지시자 허용
}

class Derived : Base(){
    fun test(base: Base): Int{ // Base의 메서드 접근 가능
        protectedFunc()
        return i // Base의 프로퍼티 접근 가능
    }
}

fun main() {
    val base = Base()
//    base.i < 접근 불가
//    base.protectedFunc() < 접근 불가
    base.access()

    val derived = Derived()
    derived.test(base)
//    derived.i < 접근 불가
//    derived.protectedFunc() < 접근 불인
}