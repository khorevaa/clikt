package com.github.ajalt.clikt.options

class FlagOptionParser(private val commandArgIndex: Int) : LongOptParser, ShortOptParser {
    override fun parseLongOpt(argv: Array<String>, index: Int, explicitValue: String?): ParseResult {
        require(explicitValue == null) // TODO
        return ParseResult(1, true, commandArgIndex)
    }

    override fun parseShortOpt(argv: Array<String>, index: Int, optionIndex: Int): ParseResult {
        return ParseResult(if (optionIndex == argv[index].lastIndex) 1 else 0, true, commandArgIndex)
    }
}

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class FlagOption(val name: String, val shortName: String = "")