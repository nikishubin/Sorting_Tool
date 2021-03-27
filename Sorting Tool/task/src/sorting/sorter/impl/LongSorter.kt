package sorting.sorter.impl

import sorting.sorter.Sorter

class LongSorter: Sorter<Long> {

    override fun sort(input: List<Long>): List<Long> {
        return input.sorted()
    }
}