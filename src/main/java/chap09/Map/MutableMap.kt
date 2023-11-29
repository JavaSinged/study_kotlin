package main.java.chap09.Map

fun main() {
    /*
    * 가변형 Map의 선언 및 초기화
    * put(key:K, value:V) : 키와 값의  쌍을 Map에 추가함
    * remove(key:K) : 키에 해당하는 요소를 Map에서 제거함
    * putAll(from: Map<out K,V>) : 인자로 주어진 Map 데이터를 갱신하거나 추가함
    * clear() : 모든 요소를 지움
    * */
    val capitalCityMap: MutableMap<String, String> // 선언할 때 키와 값의 자료형을 명시할 수 있음
            = mutableMapOf("Korea" to "Seoul", "China" to "Beijing", "Japan" to "Tokyo")
    println(capitalCityMap.values) // 값만 출력
    println(capitalCityMap.keys) // 키만 출력

    capitalCityMap.put("UK", "London") // 요소의 추가
    capitalCityMap.remove("China") // 요소의 삭제
    println(capitalCityMap)
}