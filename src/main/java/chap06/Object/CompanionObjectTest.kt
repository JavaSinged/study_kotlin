package main.java.chap06.Object

/*
* 컴패니언 객체
* - 동적인 초기화 없이 사용할 수 있는 변수 개념
* - kotlin에선 static 키워드가 없는 대신 컴패니언 객체를 제공함
* - 컴패니언 객체는 실제 객체의 *싱글톤으로 정의됨
*   * 싱글톤 : 전역변수를 사용하지 않고 객체를 하나만 생성하도록 하며,
*        생성된 객체를 어디에서든지 참고할 수 있는 디자인 패턴
*
* */
class Person {
    var id: Int = 0
    var name: String = "Youngdeok"

    companion object {
        var language: String = "Korean"
        fun work() {
            println("working...")
        }
    }
}

fun main() {
    println(Person.language) // 인스턴스 생성하지 않고 기본값 사용 : Korean 출력

    Person.language = "English" // 기본값 변경 가능
    println(Person.language)

    Person.work()

//    println(Person.name) << name은 컴패니언 객체가 아니므로 오류
}