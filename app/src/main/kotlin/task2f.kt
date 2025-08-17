fun main() {
    lesson2fTask1()
    lesson2fTask2()
    lesson2fTask3()
    lesson2fTask4()
    lesson2fTask5()
}

/*
    Вам дан код: val a: String? = null. Каковы способы, которыми вы можете обратиться
    к a без вызова исключения NullPointerException?
*/
fun lesson2fTask1() {
    println("Task 1:")
    val a: String? = null
    //безопасный вызов
    var length: Int? = a?.length // это null, тк a равна null
    println(length)
    //оператор элвис
    length = a?.length ?: 0 // это 0, тк a равна null
    println(length)
    //через if
    length = if (a != null) a.length else 0 // 0
    println(length)
}

/*
    Рассмотрите следующий код:
    fun main() {
        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
        println(intList)
    }
    Что будет выведено в результате выполнения этого кода? Почему
*/
fun lesson2fTask2() {
    println("Task 2:")
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
    println(intList)
    println("Выведено [1,2,4] тк список отфильтрован таким образом, чтобы отсеять null элементы")
}

/*
    Вам дан код: var s: String? = null. Преобразуйте его в ненулевое значение
    с помощью оператора elvis, чтобы вместо null было значение "empty".
*/
fun lesson2fTask3() {
    println("Task 3:")
    val s: String? = null
    val elvisS: String = s ?: "empty"
    println(elvisS) //empty
}

/*
    Создайте функцию, которая принимает nullable параметр
    и использует оператор !! для преобразования его в ненулевое значение.
    Что произойдет, если вы вызовете эту функцию с null?
 */
fun lesson2fTask4() {
    println("Task 4:")
    val a: String? = "hello"
    //convertToNotNull(null) // исключение
    println(convertToNotNull(a))
}

fun convertToNotNull(a: String?): String {
    return a!!
}

/*
    Создайте пользовательское исключение InvalidUserInputException, которое выбрасывается,
    когда пользователь вводит что-то неверное. Покажите, как его можно перехватить и обработать.
 */
fun lesson2fTask5() {
    println("Task 5:")
    println("Введите строку: ")
    val str: String = readln()
    try {
        checkInputName(str)
    } catch (e: InvalidUserInputException) {
        e.printStackTrace()
    } finally {
        println(str)
    }
}

class InvalidUserInputException(message: String) : Exception(message)

fun checkInputName(str: String) {
    if (str.length < 5 || str.length > 15)
        throw InvalidUserInputException("Вводимая строка должна содержать от 5 до 15 символов")
}