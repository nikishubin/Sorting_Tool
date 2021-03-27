package sorting.processor.impl

import sorting.parser.Parser
import sorting.parser.impl.WordParser
import sorting.processor.Processor
import sorting.sorter.Sorter
import sorting.sorter.impl.WordSorter
import java.util.*
import kotlin.math.roundToInt

class WordProcessor : Processor() {
    private val parser: Parser<String> = WordParser()
    private val sorter: Sorter<String> = WordSorter()
    private var data: List<String> = Collections.emptyList()

    override fun init(input: List<String>) {
        super.init(input)
        val parsed = parser.parse(this.input)
        data = sorter.sort(parsed)
    }

    override fun getTotalInfo(): String {
        return "Total words: ${data.size}."
    }

    override fun getMaximumInfo(): String {
        val maximum = data.last()
        val maximumCollection = data.filter { it == maximum }
        val maximumPercentage = maximumCollection.size.toDouble() / data.size * 100

        return "The longest word: $maximum (${maximumCollection.size} time(s)," +
                " ${maximumPercentage.roundToInt()}%)."
    }
}