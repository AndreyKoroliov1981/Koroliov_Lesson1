import models.Female
import models.Male
import models.Student

fun main() {
    println("Hello Aston!")
    val listStudent = createListStudent()
    println(listStudent)
    var key: Int
    do {
        println("Введите команду - ")
        println("0 - выход, ")
        println("1 - распечатать список студентов,")
        println("2 - распечатать список студентов парней,")
        println("3 - распечатать список студентов девушек:")
        key = readlnOrNull()?.toIntOrNull() ?: return
        if ((key < 0) || (key > 3)) println("Incorrect n, enter n >= 0, and n < 2") else {
            when (key) {
                1 -> printListStudent(listStudent)
                2 -> printListStudentMale(listStudent)
                3 -> printListStudentFemale(listStudent)
            }
        }

    } while (key != 0)

}

fun printListStudent(listStudent: List<Student>) {
    for (i in listStudent) {
        with (i) {
            println("Студент $name из $city, пол - $sex ")
        }
    }
}


fun printListStudentMale(listStudent: List<Student>) {
    for (i in listStudent) {
        when (i.sex) {
            is Male -> println(i)
            else  -> {}
        }
    }
}
fun printListStudentFemale(listStudent: List<Student>) {
    for (i in listStudent) {
        when (i.sex) {
            is Female -> println(i)
            else  -> {}
        }
    }
}
fun createListStudent(): List<Student> {
    val answer = mutableListOf<Student>()
    answer.add(Student("Вадим", "Уфа", Male()))
    answer.add(Student("Павел", "Нижнекамск", Male()))
    answer.add(Student("Евгений", "Гомель", Male()))
    answer.add(Student("Максим", "Калининград", Male()))
    answer.add(Student("Алёна", "Москва", Female()))
    return answer
}