package com.fahad.core.extension

import com.fahad.core.enum.DateFormatEnum
import java.text.SimpleDateFormat
import java.util.*

fun Date?.toCustomString(dateFormatEnum: DateFormatEnum): String? {
    return this?.let {
        SimpleDateFormat(dateFormatEnum.format, Locale.getDefault()).format(this)
    }
}