package chap03

import java.util.concurrent.locks.ReentrantLock

var sharable = 1

//동기화를 위한 코드 구현
fun main(){
    var reLock = ReentrantLock()
    lock(reLock, { criticalFunc()})
    lock(reLock) { criticalFunc()}
    lock(reLock, ::criticalFunc)

    println(sharable)
}

fun criticalFunc(){
    //공유 자원 접근 코드 사용
    sharable += 1
}

fun <T> lock(reLock: ReentrantLock, body:()->T):T{
    reLock.lock()
    try{
        return body()
    }finally {
        reLock.unlock()
    }
}