const val MINUTE = 60
const val HOUR = 3600
const val DAY = 86400

fun main() {
    println("был(а) в сети ${agoToText(61212344)}")
}

fun agoToText(timeToAgo: Int): String {
    return when {
        timeToAgo <= MINUTE -> "только что"
        timeToAgo in (MINUTE + 1) until HOUR -> "${timeToAgo / MINUTE} ${correctnessForMinute(timeToAgo)} назад"
        timeToAgo in HOUR until DAY -> "${timeToAgo / HOUR} ${correctnessForHour(timeToAgo)} назад"
        timeToAgo >= DAY && timeToAgo < DAY * 2 -> "сегодня"
        timeToAgo >= DAY * 2 && timeToAgo < DAY * 3 -> "вчера"
        timeToAgo > DAY * 3 -> "давно"
        else -> ""
    }
}

fun correctnessForMinute(timeToAgo: Int): String {
    return when (timeToAgo / MINUTE) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
}

fun correctnessForHour(timeToAgo: Int): String {
    return when (timeToAgo / HOUR) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}

