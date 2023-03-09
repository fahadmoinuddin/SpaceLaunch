package com.fahad.core.extension

import com.fahad.core.enum.DateFormatEnum
import java.text.SimpleDateFormat
import java.util.*

fun String?.toDate(dateFormat: DateFormatEnum): Date? {
    return this?.let {
        SimpleDateFormat(dateFormat.format, Locale.getDefault()).parse(this)
    }
}
