package functional
enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game {
    var path = mutableListOf(Directions.START)

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west : () -> Unit = { path.add(Directions.WEST) }
    val end : () -> Boolean = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()

        false
    }
}

fun main() {
    val game = Game()

    println(game.path)
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()

    println(game.path)

}