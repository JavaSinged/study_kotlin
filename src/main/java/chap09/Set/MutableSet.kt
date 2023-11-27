package main.java.chap09.Set

fun main() {
    //가변형 Set의 초기화

    val animals = mutableSetOf("Lion", "Dog", "Cat", "Python", "Hippo")
    println(animals)

    //요소의 추가
    animals.add("Dog") //요소가 중복되어서 변화없음
    println(animals)

    //요소의 삭제
    animals.remove("Python")
    println(animals)
}