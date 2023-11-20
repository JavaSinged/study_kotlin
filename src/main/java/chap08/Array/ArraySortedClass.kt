package main.java.chap08.Array

//sortBy 사용하기
data class Product(var name: String, val price: Double)

fun main() {
    val products = arrayOf(
        Product("Snow Ball", 870.00),
        Product("Smart Phone", 999.00),
        Product("Drone", 240.00),
        Product("Mouse", 333.55),
        Product("Keyboard", 125.99),
        Product("Monitor", 1500.99),
        Product("Tablet", 512.99)
    )

    products.sortBy { it.price } //price값에 따라 오름차순 정렬
    products.forEach { println(it) }
}