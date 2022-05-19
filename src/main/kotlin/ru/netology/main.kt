package ru.netology

fun main() {
    val seconds = 72201
    val result = agoToText(seconds)
    println(result)
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61..3599 -> "был(а) ${timeMinutes(seconds)} ${minutes(seconds)} назат"
        in 3600..86399 -> "был(а) ${timeHours(seconds)} ${hours(seconds)} назат"
        in 86400..172799 -> "был(а) сегодня"
        in 172800..259200 -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun hours(seconds: Int): String {
    return when (timeHours(seconds)) {
        1, 21 -> "час"
        2, 3, 4, 22, 23 -> "часа"
        in 5..20 -> "часов"
        else -> "больше суток"
    }
}

fun minutes(seconds: Int): String {
    return when (timeMinutes(seconds)) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4 -> "минуты"
        in 22..24 -> "минуты"
        in 32..34 -> "минуты"
        in 42..44 -> "минуты"
        in 52..54 -> "минуты"
        in 5..20 -> "минут"
        in 25..30 -> "минут"
        in 35..40 -> "минут"
        in 45..50 -> "минут"
        in 55..60 -> "минут"
        else -> "больше часа"
    }
}


fun timeMinutes(secondsTime: Int) = when (secondsTime) {
    in 1..86400 -> secondsTime / 60
    else -> 0
}

fun timeHours(minutesTime: Int) = when (minutesTime) {
    in 1..86400 -> minutesTime / 3600
    else -> 0
}
