package corona

interface Morbid {
    fun attackOrgan(organ: String)
    //default-Method in Java
    fun raiseFever(temperature: Double = 1.5) = println("temperature + $temperature")
    fun collisionMethod() = println("Morbid")
}

//another interface just to handle two similar method signatures in implementing class
interface Collide {
    fun collisionMethod() = println("Collide")
}

class Virus : Morbid, Collide {
    override fun attackOrgan(organ: String) {
        println("attacking $organ")
    }

    override fun collisionMethod() {
        //explicitly choose the implementation from the two interfaces with similar method signatures
        super<Morbid>.collisionMethod()
    }
}

fun main(args: Array<String>) {
    val corona: Morbid = Virus();
    corona.attackOrgan("Lung")
    corona.raiseFever(1.0)
    corona.collisionMethod()
}
