package main.java.chap09.list

fun main() {
    var names: List<String> = listOf("one", "two", "three")

    println(names.size) //list 크기
    println(names.get(0)) //해당 인덱스의 요소 가져오기
    println(names.indexOf("three")) //해당 요소의 인덱스 가져오기
    println(names.contains("two")) //포함 여부 확인후 포함되어 있으면 true 반환
}