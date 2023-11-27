package main.java.chap09.Set

fun main() {
    /*
    * HashSet의 초기화
    * 해시 테이블이란 내부적으로 키와 인덱스를 이용해 검색과 변경 등을 매우 빠르게 처리할 수 잇는 자료구조
    * 입력 순서와 중복된 요소는 무시함. 따로 정렬 기능은 없지만 해시값을 통해 요소를 찾아내므로 검색 속도는 상수 시간을 가짐
    * */
    val intsHashSet: HashSet<Int> = hashSetOf(6, 3, 4, 7) //블변성 기능이 없음
    intsHashSet.add(5)
    intsHashSet.remove(6)
    println(intsHashSet)
}