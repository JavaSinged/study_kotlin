package main.java.chap09.Set

import java.util.TreeSet


fun main() {

    //sortedSetOf() 함수는 자바의 TreeSet 컬렉션을 정렬된 상태로 반환함.
    val intsSortedSet: TreeSet<Int> = sortedSetOf(4, 1, 7, 2)
    intsSortedSet.add(6)
    intsSortedSet.remove(1)

    println("intsSortedSet = ${intsSortedSet}")

    intsSortedSet.clear() //모든 요소 삭제
    println("intsSortedSet = ${intsSortedSet}")
}