package classes.declarations

import classes.spices.Spice

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}