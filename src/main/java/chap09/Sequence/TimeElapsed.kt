package main.java.chap09.Sequence

fun timeElapsed(task: () -> Unit) {
    val before = System.nanoTime()
    task()
    val after = System.nanoTime()
    val speed = (after - before) / 1_000
    println("$speed ns")
}

fun main() {
    //asSequence()의 시간 성능 알아보기
    val listBench = (1..1_000_000).toList()
    timeElapsed {
        listBench
            .map { it + 1 }
            .first { it % 100 == 0 }
    }

    timeElapsed {
        listBench
            .asSequence()
            .map { it + 1 }
            .first { it % 100 == 0 }
    }
}