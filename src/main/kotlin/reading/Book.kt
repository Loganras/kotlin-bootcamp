package reading

const val MAX_BOOKS = 3

class Book (val title: String, val author: String, val year: String) {
    companion object Constants {
        const val BASE_URL = "baseurl"
    }

    fun printUrl() {
        println("url is: $BASE_URL/$title.html")
    }

    fun getInfo(): Pair<String, String> {
        return title to author
    }

    fun getTriple(): Triple< String, String, String> {
        return Triple(title, author, year)
    }

    fun canBorrow(userNumber: Int) = userNumber < MAX_BOOKS
}

fun createBookSet(): Set<String> {
    return setOf("Tristram Adventures", "Tristram Adventures 2")
}

fun main() {
    val book = Book("Tristram Adventures",
    "Deckard Cain",
    "1991")

    val (title, author, year) = book.getTriple()

    println("Here is your book $title written by $author in $year")

    // Get a set of books
    val allBooks = createBookSet()
    val library: Map<String, Set<String>> = mutableMapOf("Deckard Cain" to allBooks)
    println(library.any { it.value.contains("Tristram Adventures") })

    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book") { "Kipling"}
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)

    book.printUrl()
}