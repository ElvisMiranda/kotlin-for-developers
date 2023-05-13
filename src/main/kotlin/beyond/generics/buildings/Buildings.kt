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
class Building<T: BaseBuildingMaterial>(val baseBuildingMaterial: T) {

    val actualMaterialsNeeded: Int
        get() = baseBuildingMaterial.numberNeeded * 100

    fun build() {
        println("$actualMaterialsNeeded ${baseBuildingMaterial::class.simpleName} required")
    }
}

fun main() {
    val wood = Building(Wood())

    wood.build()
}