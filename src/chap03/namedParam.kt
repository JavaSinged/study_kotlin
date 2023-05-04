package chap03

fun namedParam(x: Int = 100, y: Int = 200, z: Int) {
    println(x + y + z)
}

fun main() {
    //매개변수 지정해서 초기값 넣기
    namedParam(x = 200, z = 100)
    namedParam(z = 100)
}