package main.java.chap08.String

import java.lang.StringBuilder

fun main() {
    val hello: String = "Hello World"
    println(hello[0])
    //hello[0] = 'K' < 오류

    //문자열 추출
    println(hello.substring(0..2))
    println(hello.subSequence(0..2))

    //문자열의 비교
    var s1 = "hello kotlin"
    var s2 = "Hello KOTLIN"
    //같으면 0, s1<s2이면 양수, 반대면 음수를 반환
    println(s1.compareTo(s2))
    println(s1.compareTo(s2, true)) //대소문자 무시

    //자바의 StingBuilder 사용
    var s = StringBuilder("Hello") //문자열이 사용할 공간을 좀 더 크게 잡을 수 있음.
    s[2] = 'x' //허용되지 않았던 요소의 변경이 가능함
    println(s)

    s.append("World")
    println(s)

    s.insert(10, "Added")
    println(s)

    s.delete(5, 10)
    println(s)
}