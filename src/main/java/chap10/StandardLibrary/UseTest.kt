package main.java.chap10.StandardLibrary

import java.io.FileOutputStream
import java.io.PrintWriter

/*
* 보통 특정 객체가 사용된 후 닫아야 하는 경우가 생기는데 이때 use() 함수를 사용하면 객체를 사용한 후 close() 함수가
* 자동적으로 호출해 닫아 줄 수 있음.
* */

fun main() {
    PrintWriter(FileOutputStream("path/output.txt")).use {
        it.println("hello")
    }
}

/*
* PrintWriter()는 파일 등에 내용을 출력합니다. 이때 인자로 FileOutputStream()을 사용해 파일 output.txt 파일에
* "hello"라는 문자열을 저장하는 소스 코드임.
* 일반적으로 파일 작업을 하고 나면 close()를 명시적으로 호출해야 하는데, use 블록 안에서는 그럴 필요가 없음.
* */