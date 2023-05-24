package chap04

fun inlineLambda2(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc2() {
    println("start of retFunc")
    inlineLambda2(13, 3) lit@{ a, b -> //lit@으로 람다식 블록의 시작 부분에 라벨 지정
        val result = a + b
        if (result > 10) return@lit //라벨을 사용한 블록의 끝부분으로 반환
        println("result: $result")
    } //해당 부분까지 종료

/**
 * 1. 암묵적 라벨
 *    inlineLambda2(13, 3) { a, b -> // 라벨을 지정 안하고
 *         val result = a + b
 *         if (result > 10) return@inlineLambda2 // 함수 이름으로 라벨을 암묵적으로 지정 가능
 *         println("result: $result")
 *     } //해당 부분까지 종료
 *
 * 2. 익명함수
 *    일반 함수처럼 작동하기 떄문에 return도 일반 함수에서 반환되는 것과 같이 사용 가능
 *    return이 여러 번 사용될 때에 유용함
 *
 *    inlineLambda2(13, 3, fun(a, b)) {
 *         val result = a + b
 *         if (result > 10) return
 *         println("result: $result")
 *     }) //해당 부분까지 종료
 */

    println("end of retFunc") //실행됨
}

fun main() {
    retFunc2()
    /** 결과
     *  start of retFunc
     *  end of retFunc
     */
}