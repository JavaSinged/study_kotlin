package main.java.chap07.moreClass

/*
* 열거형 클래스
* - 여러 개의 상수를 선언하고 열거된 값을 조건에 따라 선택할 수 있는 특수한 클래스
* */

interface Score{
    fun getScore(): Int
}

enum class MemberType(var prio: String): Score {
    NORMAL("Thrid"){
        override fun getScore(): Int = 100
    },
    SILVER("Second"){
        override fun getScore(): Int = 500
    },
    GOLD("First"){
        override fun getScore(): Int = 1500
    }
}

fun main() {
    println(MemberType.NORMAL.getScore())
    println(MemberType.GOLD)
    println(MemberType.valueOf("SILVER"))
    println(MemberType.SILVER.prio)

    //모든 값을 가져오는 반복문
    for (grade in MemberType.values()){
        println("grade.name = ${grade.name}, prio = ${grade.prio}")
    }
}