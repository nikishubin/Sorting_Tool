package sorting.parser.impl

import sorting.parser.Parser
import java.util.*

class LongParser : Parser<Long> {
    private val digitRegex = "(-?[0-9]+)".toRegex()

    override fun parse(input: List<String>): List<Long> {
        val result = mutableListOf<Long>()
        input.forEach {
            digitRegex.findAll(it).mapTo(result) { next -> next.value.toLong() }
        }
        return Collections.unmodifiableList(result)
    }
}