package sorting.parser

interface Parser<T> {
    fun parse(input: List<String>): List<T>
}