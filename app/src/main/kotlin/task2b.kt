import java.lang.Exception
import kotlin.math.pow

fun main() {
//    1.a) Напишите программу, которая принимает целое число от пользователя и проверяет,
//    является ли оно положительным, отрицательным или нулем.
//    Используйте различные варианты условных операторов (if, if-else, when).

    println("Введите целое число")
    val n = readLine()?.toIntOrNull()
    if (n == null) {
        println("Это не целое число")
    } else {
        //вариант с when
        when {
            n > 0 -> println("Ваше число больше 0")
            n < 0 -> println("Ваше число меньше 0")
            else -> println("Ваше число = 0")
        }

        //вариант с if-else
        if (n > 0) {
            println("Ваше число больше 0")
        } else if (n < 0) {
            println("Ваше число меньше 0")
        } else {
            println("Ваше число = 0")
        }

        //вариант с if
        if (n > 0) {
            println("Ваше число больше 0")
        }
        if (n < 0) {
            println("Ваше число меньше 0")
        }
        if (n == 0) {
            println("Ваше число = 0")
        }
    }
    println()

//     2.a)
//     Создайте массив из 10 чисел. Напишите цикл for, который будет выводить каждое число
//     и его квадрат.
//     После этого напишите цикл while, который будет выводить каждое число и его куб.
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (num in numbers) {
        println("num - $num, num^2 - ${num.toDouble().pow(2).toInt()}")
    }
    println()
    var i = 0
    while (i < numbers.size) {
        val num = numbers[i]
        println("num - ${num}, num^3 - ${num.toDouble().pow(3).toInt()}")
        i++
    }
    println()

    //2.b Используйте функцию repeat для вывода строки “Привет, мир!” 10 раз.
    repeat(10) {
        println("Привет, мир!")
    }
    println()

    //3.a Напишите функцию, которая принимает массив чисел и возвращает сумму только тех чисел,
    // которые больше 10. Если обнаруживается число меньше 0,
    // функция должна немедленно прекратить обработку
    // и вернуть текущую сумму (используйте return).
    val array = arrayOf(11, 10, 3, 42, -1, 11, -5)
    val sum = sumOfGreater10(array)
    println("Сумма = $sum\n")

    // 3.b Напишите цикл, который выводит числа от 1 до 10,
    // но пропускает числа 3 и 7 (используйте continue).
    for (i in 1..10) {
        if (i == 3 || i == 7) {
            continue
        }
        print("$i ")
    }
    println()

//    3.c
//    Вам дана двумерная матрица целых чисел и целевое число.
//    Напишите программу на Kotlin, чтобы искать целевое число в матрице.
//    Если целевое число найдено, выведите его позицию (строка и столбец)
//    и завершите выполнение циклов; если не найдено, выведите сообщение об этом. (используйте break).
//    Целевое значение должно вводиться пользователем.

    val matrix = arrayOf(
        arrayOf(1, 2, 3, 4, 5),
        arrayOf(6, 7, 8, 9, 10),
        arrayOf(11, 12, 13, 14, 15),
        arrayOf(16, 17, 18, 19, 20),
        arrayOf(21, 22, 23, 24, 25)
    )
    println("\nВведите целое целевое число для поиска в матрице ")
    val searchedNum = readln()?.toIntOrNull()
    if (searchedNum == null) {
        println("Вы ввели не целевое число")
    } else {
        val n = matrix.size - 1
        var m = -1
        var isFound = false
        externalLoop@ for (i in 0..n) {
            m = matrix[i].size - 1
            for (j in 0..m) {
                if (matrix[i][j] == searchedNum) {
                    isFound = true
                    println("позиция $searchedNum в матрице = (${i + 1},${j + 1})")
                    break@externalLoop
                }
            }
        }
        if (!isFound)
            println("Вашего числа нет в матрице")
    }

//    4.a
//    Напишите программу, которая просит пользователя ввести целое число.
//    Если пользователь вводит что-то другое, отлавливайте исключение и выводите сообщение об ошибке.
//    Блок finally должен выводить сообщение “Конец программы”.
    println("\nВведите целое число ")
    try {
        val a = readln().toInt()
    } catch (e: Exception) {
        println("Исключение: $e")
    } finally {
        println("Конец программы")
    }
    println()

//    4.b Создайте ситуацию, где может возникнуть исключение (например, обращение
//    к несуществующему элементу массива или деление на ноль), и обработайте это исключение,
//    выводя стек вызовов.

    try {
        print(5 / 0)
    } catch (e: Exception) {
        println("Исключение: $e")
        println("Стек вызовов:")
        for (line in e.stackTrace)
            println("at $line")
    }
}

/**
 * функция, которая принимает массив чисел и возвращает сумму только тех чисел, которые больше 10.
 * Если обнаруживается число меньше 0, функция должна немедленно прекратить обработку
 * и вернуть текущую сумму
 *
 * @param array массив целых чисел
 * @return целое число - сумма чисел больших 10
 */
fun sumOfGreater10(array: Array<Int>): Int {
    var sum = 0
    for (i in array) {
        if (i < 0) {
            return sum
        } else if (i > 10) {
            sum += i
        }
    }
    return sum
}
