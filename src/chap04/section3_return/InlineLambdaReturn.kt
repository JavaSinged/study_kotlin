package chap04.section3_return

fun main() {
    retFunc1()
    retFunc2()

}
//inline을 사용한 람다식의 반환
inline fun inlineLambda1(a:Int, b:Int, out: (Int, Int) -> Unit){
    out(a, b)
}

//라벨을 사용한 람다식의 반환
fun inlineLambda2(a:Int, b:Int, out: (Int, Int) -> Unit){
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

fun retFunc2(){
    println("start of retFunc")
    //10 이상이면 start of retFunc만 찍고, 10 미만이면 전부 추가
    inlineLambda2(3, 3) lit@{ a,b ->
        val result = a+b
        if(result > 10) return@lit
        println("result: $result")
    }
    println("end of retFunc")
}