package chap05.Relationship

/*
* 의존(Dependency) 관계
* - 한 클래스가 다른 클래승에 의존되어 영향을 주는 경우를 말함
* - 아래 예제와 같이 doctor 클래스를 생성하려고 하는데 먼저 patient의 객체가 필요한 경우
* */

class patient(val name: String, val id: Int){
    fun doctorList(d: doctor){
        println("Patient: $name, Doctor: ${d.name}")
    }
}

class doctor(val name: String, val p: patient){
    val customerId : Int = p.id

    fun patientList(){
        println("Doctor: $name, Patient: ${p.name}")
        println("Patient Id: $customerId")
    }
}

fun main() {
    val patient1 = patient("Kildong", 1234)
    val doc1 = doctor("KimSabu", patient1)
    doc1.patientList()
}