package sorting.processor.impl

import sorting.parser.Parser
import sorting.parser.impl.LongParser
import sorting.processor.Processor
import sorting.sorter.Sorter
import sorting.sorter.impl.LongSorter
import java.util.*
import kotlin.math.roundToInt

class LongProcessor : Processor() {
    private val parser: Parser<Long> = LongParser()
    private val sorter: Sorter<Long> = LongSorter()
    private var data: List<Long> = Collections.emptyList()

    override fun init(input: List<String>) {
        super.init(input)
        val parsed = parser.parse(this.input)
        data = sorter.sort(parsed)
    }

    override fun getTotalInfo(): String {
        return "Total numbers: ${data.size}."
    }

    override fun getMaximumInfo(): String {
        val maximum = data.last()
        val maximumCollection = data.filter { it == maximum }
        val maximumPercentage = maximumCollection.size.toDouble() / data.size * 100

        return "The greatest number: $maximum (${maximumCollection.size} time(s)," +
                " ${maximumPercentage.roundToInt()}%)."
    }
}