package chap03

import java.util.concurrent.locks.ReentrantLock

//동기화를 위한 코드 구현 예제 'ReentrantLock 사용'

var sharable = 1 //보호가 필요한 공유 자원

fun criticalFunc(){
    //공유 자원 접근 코드 사용
    sharable += 1
}

fun <T> lock(reLock: ReentrantLock, body:()->T):T{
    reLock.lock()
    try {
        return body()
    }finally {
        reLock.unlock()
    }
}

fun main() {
    val reLock = ReentrantLock()

    lock(reLock, { criticalFunc() })
    lock(reLock) { criticalFunc() }
    lock(reLock, ::criticalFunc)

    println(sharable)
}