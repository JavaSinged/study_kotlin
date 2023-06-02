package chap05.Class

class Bird4(var name: String, var wing: Int, var beak: String, var color: String) {

    //1. 초기화 블럭
    init {
        println("-----------초기화 블럭 시작-----------")
        println("이름은 $name, 부리는 $beak")
        this.sing(3)
        println("-----------초기화 블럭 끝-----------")
    }

    //메서드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol:Int) = println("Sing vol: $vol")
}

fun main() {
    //객체 생성과 함께 초기화 블럭 수행
    val coco = Bird4("mybird", 2, "short", "blue")

    coco.color = "yellow"
    println("coco.color: ${coco.color}")
    coco.fly()
}