package classes.spices

fun main() {
    val curry = Curry("Curry Name", "Mild")

    curry.prepareSpice()
    curry.grind()

    println("${curry.name} ${curry.spiciness}")
}

abstract class Spice(
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor) : SpiceColor by color {

    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor)
    : Spice(name, spiciness, color), Grinder {


    override fun grind() {
        println("grinding...")
    }

    override fun prepareSpice() {
        println("Preparing spice...")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color: String = "Yellow"
}