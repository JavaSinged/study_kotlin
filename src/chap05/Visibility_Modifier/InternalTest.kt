package chap05.Visibility_Modifier

/*internal 가시성 확인
*
* internal 키워드 : 같은 모듈 안에서만 볼 수 있음.
* */


internal class InternalClass{
    internal var i = 1
    internal fun icFunc(){
        i+=1
    }

    fun access(){
        icFunc()
    }
}

class Other{
    internal val ic = InternalClass()
    fun test(){
        ic.i
        ic.icFunc()
    }
}

fun main() {
    val mic = InternalClass()
    mic.i
    mic.icFunc()
}

