package beyond.generics.buildings

open class BaseBuildingMaterial() {
    open val numberNeeded: Int = 1
}
class Wood : BaseBuildingMaterial() {
    override val numberNeeded: Int
        get() = 4
}
class Brick: BaseBuildingMaterial() {
    override val numberNeeded: Int
        get() = 8
}
class Building<T: BaseBuildingMaterial>(val baseMaterialsNeeded: Int = 100) {

    val actualMaterialsNeeded: Int = baseMaterialsNeeded *

    fun <T> build() {
        println("$actualMaterialsNeeded ${T::class.simpleName} required")
    }
}

fun main() {
    val wood = Building<Wood>()

    wood.build()
}