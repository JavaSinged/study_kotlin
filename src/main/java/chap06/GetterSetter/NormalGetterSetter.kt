package main.java.chap06.GetterSetter

//getter, setter 지정 예시
class User(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
        get() = field

    var name: String = _name
        get() = field
        set(value) {
            field = value
        }

    var age: Int = _age
        get() = field
        set(value) {
            field = value
        }
}

fun main() {
    val user1 = User(1, "Kildong", 30)
    //user1.id = 2 < val 프로퍼티 값 변경 불가
    user1.age = 35 // setter
    println("user1.age = ${user1.age}") // getter
}