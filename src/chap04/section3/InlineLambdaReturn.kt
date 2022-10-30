package chap04.section3

fun main() {
    retFunc1()
    retFunc2()

}
//inline을 사용한 람다식의 반환
inline fun inlineLambda1(a:Int, b:Int, out: (Int, Int) -> Unit){
    out(a, b)
}

fun retFunc1(){
    println("start of retFunc")
    //10 이상이면 start of retFunc만 찍고, 10 미만이면 전부 추가
    inlineLambda1(3, 3){ a,b ->
        val result = a+b
        if(result > 10) return
        println("result: $result")
    }
    println("end of retFunc")
}

//라벨을 사용한 람다식의 반환
fun inlineLambda2(a:Int, b:Int, out: (Int, Int) -> Unit){
    out(a, b)
}

fun retFunc2(){
    println("start of retFunc")
    inlineLambda2(13, 3) lit@{ a,b ->
        val result = a+b
        if(result > 10) return@lit
        println("result: $result")
    }
    println("end of retFunc")
}

//암묵적 라벨
fun retFunc3(){
    println("start of retFunc")
    inlineLambda2(13, 3) { a,b ->
        val result = a+b
        if(result > 10) return@inlineLambda2
        println("result: $result")
    }
    println("end of retFunc")
}

//익명 함수를 사용한 반환
fun retFunc4(){
    println("start of retFunc")
    inlineLambda2(13, 3, fun(a, b) {
        val result = a+b
        if(result > 10) return
        println("result: $result")
    })
    println("end of retFunc")
}
