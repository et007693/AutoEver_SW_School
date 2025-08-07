package com.autoever.clazzi.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun formatDate(date: Date?): String {
    if (date == null) return ""
    val sdf = SimpleDateFormat("yyy-MM-dd HH:mm:ss", Locale.KOREA)
    sdf.timeZone = TimeZone.getTimeZone("Asia/Seoul")
    return sdf.format(date)
}

