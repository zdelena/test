/**
 * функция main - точка входа в программу
 * она содержит данные для первого блока заданий
 */
fun main() {
    // Задание 2: “Hello world”
    println("Hello, World!")
    println();

    // Задание 3: Работа с переменными
    // Создайте несколько переменных разных типов (например, Int, String, Boolean). Присвойте им значения и выведите результаты на экран. Попробуйте изменить значения этих переменных и снова выведите результаты.
    val myAge = 26
    val myName: String = "Лена"
    val isMature: Boolean = myAge > 18
    println("Меня зовут $myName")
    println("Мой возраст $myAge")
    println("Я старше 18 - $isMature")
    var ch: Char = 'a'
    println("символьная переменная = $ch")
    ch = 'z'
    println("после изменений, эта же переменная = $ch")
    println()

    // Задание 4: Работа с операторами
    // Напишите простые выражения с использованием различных операторов Kotlin
    // (арифметические, сравнения, логические). Выведите результаты на экран.
    var a = 3
    var b = 14
    println("a = $a, b = $b")
    var c = b % a;
    println("b % a = $c")
    b++
    println("b++ = $b")
    b /= a
    println("b++ / $a = $b")
    b += c
    println("b+=c = $b")

    var someBool = !(c >= a)
    println("!(b % a) >= a is $someBool")
    var result = (b < a) || !someBool
    println("result = $result  ")
    println()

    // Задание 5: Комментарии и стандартный ввод/вывод
    readout()



}