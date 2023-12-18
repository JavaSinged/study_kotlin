package main.java.chap09.Sequence

fun main() {
    //단순 메서드 체이닝 및 asSequence() 사용하기
    val list1 = listOf(1, 2, 3, 4, 5)
    val listDeffault = list1
        .map { println("map($it)"); it * it }
        .filter { println("filter($it)"); it % 2 == 0 }
    println(listDeffault)


    /*
    * asSequence()를 사용한 다음 바로 map, filter를 이요하여 메서드 체이닝을 했습니다.
    * 이때 1번과정과 2번 과정만으로는 결과를 도출할 수 없습니다.
    * 3번 과정에 의해 최정결과를 list목록으로 반환할 때, 모든 연산이 수행되고 결과물이 새로운 리스트인 listSeq에 지정됨
    * 결과를 보면 연속적으로 map과 filter가 각각 수행된 것을 알 수 있으며, 최종 결과는 toList()에 의해 만들어진 [4,16]임.
    * map의 수행 결과를 새로운 list에 만들고 이것을 다시 짝수인지 판별해 리스트를 만드는 과정이 없어진 것입니다.
    * 따라서 시퀀스를 사용하면 요소의 개수가 많을 때 속도나 메모리 측면에서 훨씬 좋은 성능을 낼 수 있습니다.
    * */
    val listSeq = list1.asSequence()
        .map { println("map($it)"); it * it } //1
        .filter { println("filter($it)"); it % 2 == 0 } //2
        .toList() //3
    println(listSeq)
}