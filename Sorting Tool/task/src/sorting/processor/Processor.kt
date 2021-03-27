package sorting.processor

import java.util.*

abstract class Processor {
    var input: List<String> = Collections.emptyList()
        private set

    open fun init(input: List<String>) {
        this.input = input
    }

    abstract fun getTotalInfo(): String
    abstract fun getMaximumInfo(): String
}