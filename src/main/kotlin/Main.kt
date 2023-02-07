import models.Female
import models.Male
import models.Student

fun main() {
    println("Hello Aston!")
    val listStudent = createListStudent()
    println(listStudent)
    var key: Int
    do {
        print("Введите команду (0 - выход, 1 - распечатать список студентов):")
        key =  readlnOrNull()?.toIntOrNull() ?: return
        if ((key<0) || (key>1)) println("Incorrect n, enter n >= 0, and n < 2") else {
            when (key) {
                1 -> printListStudent(listStudent)
            }
        }

    } while (key != 0)

}

fun printListStudent(listStudent: List<Student>) {
    for (i in listStudent) {
        println(i)
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