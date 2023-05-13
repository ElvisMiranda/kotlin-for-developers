package beyond

data class Result(val title: String, val author: String)
// Pair<String,String> as result is also useful
class Book (val title: String, val author: String, val year: Int) {

    fun getAuthorAndTitle(): Result = Result(title, author)
    fun getDetails() = Triple(this.title, author, year)

}


fun main() {
    val book = Book("Book 1", "Developer", 2018)

    val (title, author, year) = book.getDetails()

    println("Here is your book $title written by $author in $year")
}