package main.java.chap08.Generic

//where 키워드
fun <T> myMax(a: T, b: T): T where T : Number, T : Comparable<T> {
    //a를 number, b를 comparable로 제한하고 있다.
    return if (a > b) a else b
}

