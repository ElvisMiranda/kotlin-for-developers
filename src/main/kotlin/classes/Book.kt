package classes

open class Book(open val title: String, open val author: String) {

    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
    }
}

class eBook(override val title: String, override val author: String, val format: String = "text") : Book(title, author) {
    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
    }
}

fun main() {
    val eBook = eBook("Sample Ebook", "Developer")

    eBook.readPage()
    eBook.readPage()

    println("${eBook.title} ${eBook.format}")
}