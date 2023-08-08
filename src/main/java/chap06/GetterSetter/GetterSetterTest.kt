package main.java.chap06.GetterSetter

class User3(_id: Int, _name: String, _age: Int) {
    val id: Int = _id //읽기 전용
    var name: String = _name //변경 가능
    var age: Int = _age //변경 가능
}

fun main() {
    val user = User3(1, "Sean", 30)

    val name = user.name //getter에 의한 값 획득
    user.age = 41 //setter에 의한 값 지정

    println("name: $name, ${user.age}")
}