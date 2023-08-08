package main.java.chap06.Delegation

import kotlin.properties.Delegates

/*
* observable() 함수
* - 프로퍼티를 감시하고 있다가 특정 코드의 ㄹ로직에서 변경이 일어날 때 호출되어 처리함
* - 특정 이벤트에 따라 호출되므로 콜백이라고도 함
*
* 초깃값 initialValue를 NONAME으로 함
* user.name으로 값이 변경하는 이벤트를 발생시킴
* 값이 변경되면 기존의 value와 변경되는 value를 출력함
* */

class User{
    var name: String by Delegates.observable("NONAME"){
        prop, old, new ->
        println("$old -> $new")
    }
}

fun main() {
    val user = User()
    user.name = "Kildong"
    user.name = "Dooly"
}