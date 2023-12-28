package main.java.chap10.StandardLibrary

import java.io.File

/*
* also() 함수는 함수를 호출하는 객체 T를 이어지는 block에 전달하고 객체 T 자체를 반환함.
* also() 함수는 let() 함수와 역할이 거의 비슷하지만 블록 안의 코드 수행 결과와 상관없이 T인 객체 this를 반환하게 됨.
* */

fun main() {
    var m = 1
    m = m.also { it + 3 }
    println(m)
    // 연산 결과인 4가 할당되는 것이 아니라 it의 원래의 값 1이 다시 m에 할당됨

    data class Person(var name: String, var skills:String)
    var person = Person("Kildong", "Kotlin")
    val a = person.let {
        it.skills = "Android"
        "success" // 마지막 문장을 결과로 반환
    }
    println(person)
    println("a: $a") // String
    val b = person.also {
        it.skills = "Java"
        "success" // 마지막 문장은 사용되지 않음
    }
    println(person)
    println("b: $b") // Person의 객체 b

    //특정 단위의 동작 분리
    //기존의 디렉터리 생성함수
    fun makeDir1(path: String): File{
        val result = File(path)
        result.mkdirs()
        return result
    }

    //let()과 also()를 통해 개선된 함수
    fun makeDir2(path: String) =
        path.let { File(it) }
            .also { it.mkdirs() }
}