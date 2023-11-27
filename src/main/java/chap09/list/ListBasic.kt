package main.java.chap09.list

fun main() {
    //불변형 List의 사용
    var numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    var names: List<String> = listOf("one", "two", "three")

    //비어있는 list
    val emptyList: List<String> = emptyList()

    //listOfNotNull() 함수 : null을 제외한 요소만 반환해 list를 구성함
    val nonNullsList: List<Int> = listOfNotNull(2, 45, 2, null, 5, null)
    println(nonNullsList)

    //서로 다른 자료형의 List
    var mixedTypes = listOf("Hello", 1, 2.445, 's')

    for (name in names) {
        println(name)
    }

    for (num in numbers) print(num) //한 줄에서 처리하기
    println() //내용이 없을 때는 한 줄 내리는 개행
}