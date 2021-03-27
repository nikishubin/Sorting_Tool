package sorting

import sorting.processor.Processor
import sorting.processor.impl.LineProcessor
import sorting.processor.impl.LongProcessor
import sorting.processor.impl.WordProcessor
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val input = mutableListOf<String>()
    while (scanner.hasNext()) {
        input.add(scanner.nextLine())
    }

    val relevantProcessor: Processor = getRelevantProcessor(args)
    relevantProcessor.init(input)

    println(relevantProcessor.getTotalInfo())
    println(relevantProcessor.getMaximumInfo())
}

fun getRelevantProcessor(args: Array<String>): Processor {
    if (args.isEmpty()) {
        return WordProcessor()
    }

    return when (args[1]) {
        "line" -> LineProcessor()
        "word" -> WordProcessor()
        "long" -> LongProcessor()
        else -> throw UnsupportedOperationException("Selected type is not supported!")
    }
}