package sorting.sorter

interface Sorter<T> {
    fun sort(input: List<T>): List<T>
}