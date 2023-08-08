package chap05.Relationship

/*
* 연관(Association) 관계 나타내기
*
* 연관 관계란
* - 2개의 서로 분리된 클래스가 연결을 가지는 것
* - 단방향 혹은 양방향으로 연결될 수 있음
* - 클래스마다 서로 다른 생명주기를 가지고 있음
* - 단방향이든 양방향이든 각각의 객체의 생명주기에 영향을 주지 않을 때를 말함
* */
class Patient(val name: String) {
    fun doctorList(d:Doctor){
        println("Patient: $name, Doctor: ${d.name}")
    }
}

class Doctor(val name: String){
    fun patientList(p: Patient){
        println("Doctor: $name, Patient: ${p.name}")
    }
}

fun main() {
    val doc1 = Doctor("KimSabu")
    val patient1 = Patient("Kildong")
    doc1.patientList(patient1)
    patient1.doctorList(doc1)
}