package main.java.chap11.Thread

/*
* 블로킹 동작
* - 입출력 과정인 읽기나 쓰기 과정이 수행될 때 태스크 A의 코드가 더 이상 진행되지 않고 내부 메모리 영역에서 해당 작업이 마무리
* 될 때까지 코드는 멈추게 됨.
* - 태스크 A가 블로킹하는 동안 운영체제의 스케줄링 정책에 따라 우선순위가 낮은 또다른 태스크 B가 실행될 수 있음.
* - 우선순위가 높은 태스크 A의 실행이 재개되면 우선순우이가 낮은 태스크 B는 블로킹하고 태스크 A가 종료되면 다시 태스크 B가
* 재개됨.
*
* 넌블로킹 동작
* - 넌블로킹 형태의 프로세스에서는 입출력 요청을 하더라도 운영체제에 의해 EAGAIN과 같은 시그널을 태스크 A가 받아서 실행을 재개
* 할 수 있음.
* - 이때 태스크 A는 다른 루틴을 수행하다가 내부적으로 입출력 완료 시그널을 받은 후 콜백 루틴 등을 호출해 완료된 이후의 일을
* 처리 할 수 있음.
* - 태스크 A를 수행하는 도주엥 또 다른 태스크 B가 생성될 수 있는데 이때 태스크 A와 B는 동기적으로 수행될 수 있음.
*
* */

//java thread 생성
// 1. thread 클래스를 상속받아 구현하기
//Thread 클래스를 직접 상속받아 구현하여 다중상 속이 허용되지 않기 때문에 Thread 이외의 클래스를 상속할 수 없음.
class SimpleThread : Thread() {
    override fun run() {
        println("Curreent Threads: ${Thread.currentThread()}")
    }
}


// 2. Runnable 인터페이스로부터 run() 메서드 구현하기
class SimpleRunnable : Runnable {
    override fun run() {
        println("Current Thread: ${Thread.currentThread()}")
    }
}

fun main() {
    val thread1 = SimpleThread()
    thread1.start()

    //익명 객체를 이용한 스레드의 실행
    object : Thread() {
        override fun run() {
            println("Current Threads(object): ${Thread.currentThread()}")
        }
    }.start()

    //람다식을 이요한 스레드의 생성
    Thread({
        println("Current Threads(lambda): ${Thread.currentThread()}")
    }).start()

    val runnable = SimpleRunnable()
    val thread2 = Thread(runnable)
    thread2.start()
}