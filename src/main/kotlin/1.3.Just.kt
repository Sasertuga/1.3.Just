const val MINUTE = 60
const val HOUR = 3600
const val DAY = 86400

fun main() {
    agoToText(56478)
}

fun agoToText(timeToAgo: Int) {
    val toMinute = timeToAgo / MINUTE
    val toHour = timeToAgo / HOUR

    val correctnessForMinute = when {
        toMinute % 10 == 1 && toMinute != 11 -> "минуту"
        toMinute == 12 || toMinute == 13 || toMinute == 14 -> "минут"
        toMinute % 10 == 2 || toMinute % 10 == 3 || toMinute % 10 == 4 -> "минуты"
        else -> "минут"
    }

    val correctnessForHour = when {
        toHour % 10 == 1 -> "час"
        toHour % 10 == 2 || toHour % 10 == 3 || toHour % 10 == 4 -> "часа"
        else -> "часов"
    }

    when {
        timeToAgo < MINUTE -> println("был(а) только что")
        timeToAgo in MINUTE until HOUR -> println("был(а) $toMinute $correctnessForMinute назад")
        timeToAgo in HOUR until DAY -> println("был(а) $toHour $correctnessForHour назад")
        timeToAgo >= DAY && timeToAgo < DAY * 2 -> println("был(а) сегодня")
        timeToAgo >= DAY * 2 && timeToAgo < DAY * 3 -> println("был(а) вчера")
        timeToAgo >= DAY * 3 -> println("был(а) давно")
    }
}