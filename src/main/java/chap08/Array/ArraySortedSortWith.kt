package main.java.chap08.Array

// Comparator를 사용해 제품 비교하기

data class Products(val name: String, val price: Double)

fun main() {
    val product = arrayOf(
        Products("Snow Ball", 870.00),
        Products("Smart Phone", 999.00),
        Products("Drone", 240.00),
        Products("Mouse", 333.55),
        Products("Keyboard", 125.99),
        Products("Monitor", 1500.99),
        Products("Tablet", 512.99)
    )

    product.sortWith(//Comparator를 이용해 두 객체를 비교하여 p1이 크면 1, 같으면 0, 작으면 -1
        Comparator<Products> { p1, p2 ->
            when {
                p1.price > p2.price -> 1
                p1.price == p2.price -> 0
                else -> -1
            }
        }
    )

//    product.forEach { println(it) }

    //compareBy() 추가하기
    product.sortWith(compareBy({it.name}, {it.price})) //두 개의 객체를 비교하는 문법
    product.forEach { println(it) }
}