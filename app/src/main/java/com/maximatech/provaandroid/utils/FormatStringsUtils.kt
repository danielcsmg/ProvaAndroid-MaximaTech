package com.maximatech.provaandroid.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun Int.formatIntegerWithThousandSeparator(): String {
    val symbols = DecimalFormatSymbols(Locale.ROOT)
    symbols.groupingSeparator = '.'

    val formatter = DecimalFormat("#,##0", symbols)

    return formatter.format(toLong())
}