package main.java.chap08.Array

import java.util.*

//기본적인 정렬 방법

fun main() {
    val arr = arrayOf(8, 4, 3, 2, 5, 9, 1)
    //1. 오름차순, 내림차순으로 정렬된 일반 배열로 반환
    val sortedNums = arr.sortedArray()
    println("ASC: " + Arrays.toString(sortedNums))

    val sortedNumsDesc = arr.sortedArrayDescending()
    println("DEC: " + Arrays.toString(sortedNumsDesc))

    //2. 원본 배열에 대한 정렬
    arr.sort(1, 3) //sort(fromIndex, toIndex)
    println("ORI: " + Arrays.toString(arr))
    arr.sortDescending()
    println("ORI: " + Arrays.toString(arr))

    //3. List로 반환
    val listSorted: List<Int> = arr.sorted()
    val listDesc: List<Int> = arr.sortedDescending()
    println("LST: " + listSorted)
    println("LST: " + listDesc)

    //4. SortBy를 이용한 특정 표현식에 따른 정렬
    val items = arrayOf<String>("Dog", "Cat", "Lion", "Kangaroo", "Po")
    items.sortBy { item -> item.length }
    println(Arrays.toString(items))
}