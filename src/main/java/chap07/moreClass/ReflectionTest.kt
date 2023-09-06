package main.java.chap07.moreClass
//
///*
//* 애노테이션 클래스
//* - 코드에 부가 정보를 추가하느 ㄴ역할을 함
//* - @ 기호와 함께 나타내는 표기법으로 주로 컴파일러나 프로그램 실행 시간에서 사전 처리를 위해 사용함
//*
//* 애노테이션 선언 및 사용
//* annotation class Fancy
//* @Fancy class MyClass{...}
//*
//* 애노테이션 속성
//* - @Target : 애노테이션이 지정되어 사용할 종류(클래스, 함수, 프로퍼티 등)를 정의
//* - @Retention : 애노테이션을 컴파일된 클래스 파일에 저장할 것인 실행 시간에 반영할 것인지 결정
//* - @Repeatable : 애노테이션을 같은 요소에 여러 번 사용 가능하게 할지를 결정
//* - @MustBeDocumented : 애노테이션이 API의 일부분으로 문서화하기 위해 사용
//* */
//
////리플렉션 테스트
//import kotlin.reflect.KClass
//import kotlin.reflect.full.memberFunctions
//import kotlin.reflect.full.memberProperties
//
//class User(val id: Int, val name: String, var grade: String ="Normal") {
//    fun check() {
//        if (grade == "Normal") println("You need to get the Silver grade")
//    }
//}
//
//fun main() {
//    // 타입을 출력
//    println(User::class)
//    // 클래스의 프로퍼티와 메서드의 정보를 출력
//    val classInfo = User::class
//    classInfo.memberProperties.forEach {
//        println("Property name: ${it.name}, type: ${it.returnType}")
//    }
//    classInfo.memberFunctions.forEach {
//        println("Function name: ${it.name}, type: ${it.returnType}")
//    }
//
//    // 함수에 전달해 자료형을 알아낸다.
//    getKotlinType(User::class) // 클래스 레퍼런스를 위해 ::class 사용, KClass<T>반환
//    getJavaType(User::class.java) // 자바의 java.lang.Class를 이용
//}
//
//fun getKotlinType(obj: KClass<*>) {
//    println(obj.qualifiedName)
//}
//
//fun getJavaType(obj: Any) {
//    println("Class ${obj.javaClass.simpleName}")
//    println("Properties\n")
//    obj.javaClass.declaredFields.forEach {
//        println("${it.name} of ${it.type}")
//    }
//    println()
//    println("Functions\n")
//    obj.javaClass.declaredMethods.forEach {
//        println(it.name)
//    }
//}