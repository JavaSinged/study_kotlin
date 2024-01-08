package main.java.chap10.FileIO

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.lang.Exception

//PrintWriter로 파일에 쓰기

fun main() {
    val outString: String = "안녕하세요!\tHello\r\nWorld!." //문자열의 구성
    val path = "/Users/sinjiung/Desktop/testfile.txt"

    /* 1. 기본 사용 방법
    val file = File(path)
    val printWriter = PrintWriter(file)

    printWriter.println(outString) //파일에 출력
    printWriter.close()

    2. use를 이용한 자동 닫기
    File(path).printWriter().use { out -> out.println(outString) }
    File(path).printWriter().use { it.println(outString) }

    3. BufferedWriter의 이용
    File(path).bufferedWriter().use { it.write(outString) }

    4. writeText의 이용
    val file = File(path)
    file.writeText(outString)
    file.appendText("\nDo great work!") //파일에 문자열 추가

    5. FileWriter를 사용한 기록
    var writer = FileWriter(path, true) //경로, append 여부
    try {
        writer.write(outString)
    } catch (e: Exception) {
    } finally {
        writer.close()
    }

    - 축소형
    FileWriter(path, true).uses { it.write(outString) }
     */

}