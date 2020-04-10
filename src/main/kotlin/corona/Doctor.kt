package corona

//new extensions of Doctor need to go as inner classes into doctor,
sealed class Doctor {
    //primary constructor for Epidemiologist statistic property gets generated
    class Epidemiologist(val antibiotic: String) : Doctor()
    //primary constructor
    class Surgeon(_surgery: String) : Doctor() {
        val surgery = _surgery
    }
    //secondary constructor for property degree
    class Virologist constructor(_antiviral: String) : Doctor() {
        val antiviral: String

        init {
            antiviral = _antiviral
        }
    }
}

fun treatDisease(doctor: Doctor) {
    //no else branch necessary because doctor is a sealed class
    //compiler error here when a new extension of Doctor gets added above
    when(doctor) {
        is Doctor.Epidemiologist -> println("give antibiotics ${doctor.antibiotic}")
        is Doctor.Surgeon -> println("make surgery ${doctor.surgery}")
        is Doctor.Virologist -> println("give antivirals ${doctor.antiviral}")
    }
}

fun main(args: Array<String>) {
    val doctor: Doctor = Doctor.Surgeon("Lung transplantation")
    treatDisease(doctor)
}
