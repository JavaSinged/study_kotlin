package main.java.chap10.StandardLibrary

/*
* with() 함수는 인자로 받는 객체를 이어지는 block의 receiver로 전달하며 결괏값을 반환함.
* with()함수는 run() 함수와 기능이 거의 동일한데, run() 함수의 경우 receiver가 없지만
* with 함수에서는 receiver로 전달할 객체를 처리하므로 객체의 위치가 달라짐.
* */

fun main() {
    data class User(val name:String, var skills: String, var email: String? = null)
    val user = User("Kildong", "default")

    val result = with(user){
        skills = "Kotlin"
        email = "kildong@example,com"
        "success" //이 경우 result는 "success"를 할당하는 String형의 변수가 됨
    }

    println(user)
    println("result: $result")
}