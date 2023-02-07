import models.Female
import models.Male
import models.Student

fun main() {
    println("Hello Aston!")
    var listStudent = createListStudent()
    println(listStudent)
    var key: Int
    do {
        println("Введите команду - ")
        println("0 - выход, ")
        println("1 - распечатать список студентов,")
        println("2 - распечатать список студентов парней,")
        println("3 - распечатать список студентов девушек,")
        println("4 - перемешать список студентов:")
        key = readlnOrNull()?.toIntOrNull() ?: return
        if ((key < 0) || (key > 4)) println("Incorrect n, enter n >= 0, and n < 2") else {
            when (key) {
                1 -> printListStudent(listStudent)
                2 -> printListStudentMale(listStudent)
                3 -> printListStudentFemale(listStudent)
                4 -> shuffleListStudent(listStudent)?.let {
                    println("перемешать список студентов удалось")
                    listStudent = it
                }
            }
        }

    } while (key != 0)

}

fun printListStudent(listStudent: List<Student>) {
    for (i in listStudent) {
        with(i) {
            println("Студент $name из $city, пол - $sex ")
        }
    }
}

fun shuffleListStudent(listStudent: List<Student>): List<Student>? {
    if (listStudent.size % 2 != 0) return null
    val newListStudent = listStudent.toMutableList()
    for (i in 1..listStudent.size / 2) {
        newListStudent[i*2-2] = newListStudent[i*2-1].also { newListStudent[i*2-1] = newListStudent[i*2-2] }
    }
    return newListStudent.toList()
}


fun printListStudentMale(listStudent: List<Student>) {
    for (i in listStudent) {
        when (i.sex) {
            is Male -> println(i)
            else -> {}
        }
    }
}

fun printListStudentFemale(listStudent: List<Student>) {
    for (i in listStudent) {
        when (i.sex) {
            is Female -> println(i)
            else -> {}
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