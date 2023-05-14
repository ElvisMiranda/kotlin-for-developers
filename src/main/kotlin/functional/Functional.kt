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

    private val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end : () -> Boolean = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()

        false
    }

    private fun move(where: () -> Boolean) {
        where.invoke()
    }

    fun makeMove(direction: String?) {
        if (direction.equals("n")) move(north)
        else if (direction.equals("s")) move(south)
        else if (direction.equals("e")) move(east)
        else if (direction.equals("w")) move(west)
        else move(end)
    }
}

fun main() {
    val game = Game()

//    println(game.path)
//    game.north()
//    game.south()
//    game.east()
//    game.west()
//    game.end()
//
//    println(game.path)

    while (true) {
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readlnOrNull())
    }
}