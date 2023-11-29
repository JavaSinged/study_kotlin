package main.java.chap09.Map

/*
* Map은 키와 값으로 구성된 요소를 저장함
* 키값은 중복될 수 없지만 값은 중복 저장 가능
*
* size : 크기 반환
* keys : 모든 key 반환
* values : 모든 value 반환
* isEmpty() : 비어있으면 true, 아니면 false 반환
* containsKey(key:K) 인자에 해당하는 키가 있으면 true, 없으면 false 반환
* containsValue(value:V) 인자에 해당하는 값이 있으면 true, 없으면 false 반환
* get(key: K) : 키에 해당하는 값을 반환하며, 없으면 null을 반환함
* */

fun main() {
    //불변형 Map의 선언 및 초기화 key to value 형식으로 저장
    val langMap: Map<Int, String> = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
    for ((key, value) in langMap) { //키와 값의 쌍울 출력
        println("key=$key, value=$value")
    }
    println("langMap[22] = ${langMap[22]}") //키 22의 대한 값 출력
    println("langMap.get(22) = ${langMap.get(22)}") //위와 동일한 표현
    println("langMap.kets = ${langMap.keys}") //맵의 모든 키 출력
    println(langMap.values) //맵의 모든 값 출력
}