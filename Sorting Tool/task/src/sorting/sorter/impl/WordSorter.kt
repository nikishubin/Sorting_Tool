package sorting.sorter.impl

import sorting.sorter.Sorter

class WordSorter: Sorter<String> {

    override fun sort(input: List<String>): List<String> {
        return input.sortedWith(compareBy { it.length })
    }
}