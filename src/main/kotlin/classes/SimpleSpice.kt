package classes

class SimpleSpice {
    val name: String = "curry"
    val spiceness: String = "mild"
    val heat: Int
        get() = if (spiceness == "mild")  5 else 0
}

fun main() {
    val simpleSpice = SimpleSpice()

    println("Spice: ${simpleSpice.name} ${simpleSpice.heat}")
}