package chap03.lambda

//매개변수가 없는 람다식 선언
fun noParam(out: () -> String) = println(out())

//매개변수가 1개 있는 람다식 선언
fun oneParam(out: (String) -> String) {
    println(out("OneParam"))
}

//매개변수가 2개 있는 람다식 함수 선언
fun moreParam(out: (String, String) -> String) {
    println(out("OneParam", "TwoParam"))
}

//일반 매개변수와 람다식 매개변수 같이 사용하기
fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}

//일반 함수에 람다식 매개변수 2개 이상 사용하기
fun twoLambda(first:(String, String)->String, second:(String)->String){
    println(first("OneParam", "TwoParam"))
    println(second("OneParam"))
}

fun main() {

    //1. 매개변수가 없는 람다식 호출
    noParam { "hello world!" }
    noParam({ "hello world!" })

    //2. 매개변수가 1개 있는 람다식 호출 it으로 대체 가능
    oneParam({ a -> "Hello World! $a" })
    oneParam { a -> "Hello World! $a" }
    oneParam { "Hello World! $it" }

    //3. 매개변수가 2개 있는 람다식 호출, 매개변수 생략 불가, _ 로 매개변수 사용 안할 수 있음
    moreParam { a, b -> "Hello World! $a $b" }
    moreParam { _, b -> "Hello World! $b" }

    //4-1. 인자와 함께 람다식을 사용하는 경우
    withArgs("Args1","Args2", {a,b -> "Hello World! $a $b"})
    //4-2. withArgs() 함수의 마지막 인자가 람다식인 경우 소괄호 바깥으로 분리할 수 있음
    withArgs("Args1","Args2") {a,b -> "Hello World! $a $b"}

    //5. 2개 이상 람다식을 매개변수 ( {첫번째}, {두번째} ) << 이런식으로 기술
    twoLambda({a,b ->"First $a $b"}, {"Second $it"})
    twoLambda({a,b ->"First $a $b"}) {"Second $it"}

}