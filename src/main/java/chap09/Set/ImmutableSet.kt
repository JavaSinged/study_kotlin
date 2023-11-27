package main.java.chap09.Set

fun main() {
    /*
    * 불변형 Set의 초기화
    *
    * Set는 정해진 순서가 없는 요소들의 집합을 나타내는 컬렉션
    * 중복한 값을 가질 수 없음.
    * setOf()를 이용해 불변형 set생성
    *
    * */
    val mixedTypesSet = setOf("Hello", 5, "world", 3.14, 'c') //자료형 혼합 초기화
    var intSet: Set<Int> = setOf(1, 5, 5) //정수형만 초기화

    println(mixedTypesSet)
    println(intSet)
}