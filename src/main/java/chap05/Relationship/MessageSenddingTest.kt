package chap05.Relationship

/*
    programing flow
* 1. Touchscreen 객체 생성
* 2. pin번호 일치 확인
* 3. getBalance()로 계좌번호로 잔고 조회
* 4. amount에 잔고 반환
* 5. transact로 잔고 설정
* 6. 설정된 잔고 반환
* */

class Touchscreen {
    private val bankController = BankController("kildong")
    fun pin(_password: Int) {
        if (bankController.password == _password) {
            bankController.getBalance("123-456")
        }
    }
    fun transact(_amount: Int) {
        bankController.setBalance(_amount)
    }
}

class BankController(val name: String) {
    private val account = Account(name)
    val password = account.password
    fun getBalance(accountNum: String) {
        account.getBalance(accountNum)
    }
    fun setBalance(_amount: Int) {
        account.amount =_amount
    }

    class Account(val name: String) {
        var amount: Int = 0
        val password: Int = 1234
        fun getBalance(accountNum: String): Boolean {
            if (accountNum == "123-456")
                println(amount)
            return true
        }
    }
}

fun main() {
    val tc = Touchscreen()
    tc.pin(1234)
    tc.transact(100)
    tc.pin(1234)
}