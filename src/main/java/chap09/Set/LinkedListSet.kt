package main.java.chap09.Set

fun main() {
    /*
    * LinkedSetOf() 함수는 링크드 리스트를 사용해 구현된 해시 테이블에 요소를 저장함.
    * 저장 공간을 좀 더 효율적으로 사용할 수 있음.
    * */

    val intsLinkedHashSet : java.util.LinkedHashSet<Int> = linkedSetOf(35, 21, 76, 26, 75)
    intsLinkedHashSet.add(4)
    intsLinkedHashSet.remove(21)

    println(intsLinkedHashSet)
    intsLinkedHashSet.clear()
    println(intsLinkedHashSet)
}