import java.time.LocalDateTime
import java.time.LocalDateTime.*
import java.time.temporal.ChronoUnit

public fun main() {

//  println(secondsFromLastVisit()) //Прошло секунд со времени последнего визита - контроль
    println(ago(secondsFromLastVisit()))
}

fun secondsFromLastVisit(): Int {
    val currentDateTime: LocalDateTime? = now()// parse the date and time with a suitable formatter
    var lastVisitDateTime: LocalDateTime = parse("2023-03-21T19:31:02")//Введите дату и время последнего визита
    val diffSeconds: Int = ChronoUnit.SECONDS.between(lastVisitDateTime, currentDateTime).toInt()
    return diffSeconds
}

fun ago(diffSeconds: Int): Any {

    return when {
        diffSeconds < 60 -> "Был(а) только что"

        diffSeconds in (61..(60 * 60)) -> {
            return when {
                (diffSeconds / 60) == 1 -> "Был(а) 1 минуту назад"
                (diffSeconds / 60) == 2 -> "Был(а) 2 минуты назад"
                (diffSeconds / 60) == 5 -> "Был(а) 5 минут назад"
                (diffSeconds / 60) == 11 -> "Был(а) 11 минут назад"
                (diffSeconds / 60) == 21 -> "Был(а) 21 минуту назад"
                (diffSeconds / 60) == 22 -> "Был(а) 22 минуты назад"
                (diffSeconds / 60) == 23 -> "Был(а) 23 минуты назад"
                (diffSeconds / 60) == 24 -> "Был(а) 24 минуты назад"
                else -> "Был(а) ${minutes(diffSeconds)} минут назад"
            }
        }

        diffSeconds in (((60 * 60) + 1)..(60 * 60 * 24)) -> {
            return when {
                (diffSeconds / 3600) == 1 -> "Был(а) 1 час назад"
                (diffSeconds / 3600) == 2 -> "Был(а) 2 часа назад"
                (diffSeconds / 3600) == 3 -> "Был(а) 3 часа назад"
                (diffSeconds / 3600) == 4 -> "Был(а) 4 часа назад"
                (diffSeconds / 3600) == 21 -> "Был(а) 21 час назад"
                (diffSeconds / 3600) == 22 -> "Был(а) 22 часа назад"
                (diffSeconds / 3600) == 23 -> "Был(а) 23 часа назад"
                (diffSeconds / 3600) == 24 -> "Был(а) сутки назад"
                else -> "Был(а) ${hours(diffSeconds)} часов назад"
            }
        }

        diffSeconds in (((60 * 60 * 24) + 1)..(60 * 60 * 48)) -> "Был(а) вчера"
        diffSeconds in (((60 * 60 * 48) + 1)..(60 * 60 * 72)) -> "Был(а) позавчера"
        diffSeconds > (60 * 60 * 72) -> "Был(а) давно"
        else -> "Вообще не был(а)"
    }

}

fun minutes(seconds: Int): Int {
    return (seconds / 60)
}

fun hours(seconds: Int): Int {
    return (seconds / 3600)
}
