package sorting.parser.impl

import sorting.parser.Parser
import java.util.*

class WordParser: Parser<String> {
    private val wordRegex = "([^\\s]+)".toRegex()

    override fun parse(input: List<String>): List<String> {
        val result = mutableListOf<String>()
        input.forEach {
            wordRegex.findAll(it).mapTo(result) { next -> next.value }
        }
        return Collections.unmodifiableList(result)
    }
}