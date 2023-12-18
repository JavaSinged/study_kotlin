package main.java.chap09.Sequence

fun main() {
    /*
    * Sequence : 순차적인 컬렉션으로 요소의 크기를 특정ㅇ하지 않고, 나중에 결정할 수 있는 특수한 컬렉션
    * 예를 들어 파일에서 줄 단위로 읽어서 요소를 만들 때 해당 파일의 끝을 모르면 줄이 언제 끝날지 알 수 없는 경우가 있는데
    * 이럴 때 사용할 수 있다.
    * 따라서 시퀀스는 처리 중에는 계산하고 있지 않다가 toList()나 count()같은 최종 연산에 의해 결정됨
    *
    * 특정 값을 생성하기 위해 generateSequeence()를 사용할 수 있음.
    * */

    //시드 값 1을 시작으로 1씩 증가하는 시퀀스 정의
    val nums: Sequence<Int> = generateSequence(1){it+1}

    //take()를 사용해 원하는 요소 개수만큼 획득하고 toList()를 사용해 List 컬렉션 반환
    println(nums.take(10).toList())

    //map이나 filter 연산 처리
    val squares = generateSequence(1){it+1}.map { it*it }
    println(squares.take(10).toList())

    val oddSquares = squares.filter { it % 2 != 0 }
    println(oddSquares.take(5).toList())
}