package main.java.chap06.GetterSetter

//임시적인 보조 프로퍼티 사용 예시
//보조 필드인 field를 사용하지 않고 추가로 내부의 프로퍼티를 임시로 선언해 사용하는 것

class User2(_id: Int, _name: String, _age: Int){
    val id : Int = _id
    private var tempName : String? = null
    var name: String = _name
        get() {
            if (tempName == null) tempName = "NONAME"
            return tempName ?: throw AssertionError("Asserted by others")
        }

    var age : Int = _age
}

fun main() {
    val user1 = User2(1, "Kildong", 35)
    user1.name = ""
    println("user3.name = ${user1.name}")
}
