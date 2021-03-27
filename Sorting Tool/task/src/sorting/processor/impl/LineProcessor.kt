package sorting.processor.impl

import sorting.parser.Parser
import sorting.parser.impl.LineParser
import sorting.processor.Processor
import sorting.sorter.Sorter
import sorting.sorter.impl.LineSorter
import java.util.*
import kotlin.math.roundToInt

class LineProcessor : Processor() {
    private val parser: Parser<String> = LineParser()
    private val sorter: Sorter<String> = LineSorter()
    private var data: List<String> = Collections.emptyList()

    override fun init(input: List<String>) {
        super.init(input)
        val parsed = parser.parse(this.input)
        data = sorter.sort(parsed)
    }

    override fun getTotalInfo(): String {
        return "Total lines: ${data.size}."
    }

    override fun getMaximumInfo(): String {
        val maximum = data.last()
        val maximumCollection = data.filter { it.length == maximum.length }
        val maximumPercentage = maximumCollection.size.toDouble() / data.size * 100

        return "The longest line:\n" +
                "$maximum\n" +
                "(${maximumCollection.size} time(s), ${maximumPercentage.roundToInt()}%)."
    }
}