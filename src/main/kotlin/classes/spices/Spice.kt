package classes.spices

import classes.declarations.SpiceContainer

fun main() {
    val curry = Curry("Curry Name", "Mild")

    curry.prepareSpice()
    curry.grind()

    println("${curry.name} ${curry.spiciness}")

    println("Using data classes")

    val spiceCabinet = listOf(
        SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium")),
        SpiceContainer(Curry("Green Curry", "spicy"))
        )

    for (container in spiceCabinet) {
        println("${container.label}, color: ${container.spice.color}")
    }
}

sealed class Spice(
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
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color: Color = Color.YELLOW
}

enum class Color(val rgb: Int) {
    YELLOW(0xFFFF00),
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);
}