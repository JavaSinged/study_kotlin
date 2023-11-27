package main.java.chap09.list

//가변성 list 사용하기
fun main() {
    //가변성 list를 생성하고 자바의 ArrayList로 반환
    val stringList: ArrayList<String> = arrayListOf("Hello", "Kotlin", "Wow")
    stringList.add("Java") //추가
    stringList.remove("Hello") //삭제
    println(stringList)
}