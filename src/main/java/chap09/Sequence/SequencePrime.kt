package main.java.chap09.Sequence

fun main() {
    /*
    * 시퀀스를 이용한 소수 출력하기
    * 초기 시드값은 2부터 시작하고 두 번째 Pair 값은 람다식에서 Pair<Int, Sequence<Int>> 형태로 구성되었기 때문에
    * 다시 한번 시퀀스를 생성하고 있습니닫. 여기서는 시드값 3을 사용했습니다.
    * 이후 이 값에서 2씩 더해집니다. 현재 시퀀스의 값과 다음 소수의 값이 나누어 떨어진 값이 0이 아닌 경우 골라내어
    * 소수를 구성하고 있습니다.
    *
    * */
    val primes = generateSequence(2 to generateSequence(3) { it + 2 }) {
        val currSeq = it.second.iterator()
        val nextPrime = currSeq.next()
        nextPrime to currSeq.asSequence().filter { it % nextPrime != 0 }
    }.map { it.first }
    println(primes.take(10).toList())
}