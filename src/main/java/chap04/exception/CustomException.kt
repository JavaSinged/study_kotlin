package chap04.exception

class InvalidNameException(message:String) : Exception(message)

fun validateName(name : String){
    if (name.matches(Regex(".*\\d+.*"))){ //숫자가 포함되어 있는지 확인하는 정규식
        throw InvalidNameException("Your name : $name : contains numerals.")
    }
}

fun main() {
    var name = "Kildong123"

    try {
        validateName(name)
    }catch (e: InvalidNameException){
        println(e.message)
    }catch (e : Exception){
        println(e.message)
    }
}