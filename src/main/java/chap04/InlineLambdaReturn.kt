package chap04

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc(){
    println("start of retFunc")
    inlineLambda(13, 3){
        a, b->
        val result = a+b
        if (result > 10) return //함수 종료
        println("result: $result") // <- 이부분 아래로 실행 안됨
    }
    println("end of retFunc")
}

fun main() {
    retFunc()
    // 결과 : start of retFunc
}