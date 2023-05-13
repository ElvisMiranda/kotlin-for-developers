package beyond

data class Result(val title: String, val author: String)
// Pair<String,String> as result is also useful

const val MAX_BOOKS = 10

class Book (val title: String, val author: String, val year: Int, var pages: Int) {

    companion object {
        const val BASE_URL = "http://sample/"
    }

    fun getAuthorAndTitle(): Result = Result(title, author)
    fun getDetails() = Triple(title, author, year)

    fun canBorrow(hasBooks: Int) = hasBooks < MAX_BOOKS

    fun printUrl() = println("$BASE_URL$title.html")
}

fun Book.weight() = pages * 1.5
fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

fun main() {
    val book = Book("Book 1", "Developer", 2018, 150)

    val (title, author, year) = book.getDetails()

    println("Here is your book $title written by $author in $year")

    val allBooks: Set<String> = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library: Map<String, Set<String>> = mapOf("Shakespeare" to allBooks)

    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf("Author 2" to "Book 2")
    println(moreBooks.getOrPut("Author 2") { "No Books" })

    println(book.canBorrow(10))
    println(book.printUrl())

    val puppy = Puppy()
    val puppyBook = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    puppy.playWithBook(puppyBook)
    puppy.playWithBook(puppyBook)
    puppy.playWithBook(puppyBook)
    puppy.playWithBook(puppyBook)
}