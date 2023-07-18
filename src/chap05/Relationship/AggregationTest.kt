package chap05.Relationship

/*
* 집합(Aggregation) 관계
* - 연관 관계와 유사하지만 특정 객체를 소유한다는 개념이 추가됨

* 연못에 오리를 집개하는 예제
* - 연못은 여럿의 오리를 소유할 수 있음
* - 오리는 여러 개의 연못을 가질 수 없음
* - MutableList구조로 여러 개의 데이터를 담을 수 있게 함
* */

class Pond(_name: String, _members: MutableList<Duck>) {
    val name: String = _name
    val members: MutableList<Duck> = _members

    constructor(_name: String) : this(_name, mutableListOf<Duck>())
}

class Duck(val name: String)

fun main() {
    // 두 개체는 서로 생명주기에 영향을 주지 않음
    val pond = Pond("myFavorite")
    val duck1 = Duck("Duck1")
    val duck2 = Duck("Duck2")

    // 연못에 오리를 추가 - 연못에 오리가 집합
    pond.members.add(duck1)
    pond.members.add(duck2)

    // 연못에 있는 오리 출력
    for (duck in pond.members)
        println(duck.name)
}