package main.java.chap06.GetterSetter

//custom getter, setter 사용 예시
class User1(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
    var name: String = _name
        set(value) {
            println("The name was changed")
            field = value.uppercase()
        }

    var age: Int = _age
}

fun main() {
    val user1 = User1(1, "Kildong", 35)
    user1.name = "coco"
    println("user3.name = ${user1.name}")
}