package main.java.chap09.list

fun main() {
    //가변성 list의 생성 및 추가, 삭제, 변경
    val mutableList: MutableList<String> = mutableListOf("Killdong", "Dooly", "Chelsu")
    mutableList.add("Ben") //추가
    mutableList.removeAt(1) //인덱스 1번 삭제
    mutableList[0] = "Sean" //인덱스 0번을 변경 set()과 같은 역할
    println(mutableList)

    //자료형의 혼합
    val mutableListMixed = mutableListOf("Android", "Apple", 5, 6, 'X')
    println(mutableListMixed)
}