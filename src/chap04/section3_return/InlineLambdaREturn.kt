package chap04.section3_return

fun main() {
    retFunc()
}

inline fun inlineLambda(a:Int, b:Int, out: (Int, Int) -> Unit){
    out(a, b)
}

fun retFunc(){
    println("start of retFunc")
    //10 이상이면 start of retFunc만 찍고, 10 미만이면 전부 추가
    inlineLambda(3, 3){ a,b ->
        val result = a+b
        if(result > 10) return
        println("result: $result")
    }
    println("end of retFunc")
}