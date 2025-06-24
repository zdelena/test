fun main() {
    lesson2eTask1()
    lesson2eTask2()
    lesson2eTask3()
    lesson2eTask4()
    lesson2eTask5()
    lesson2eTask6()
    lesson2eTask7()
    lesson2eTask8()
    lesson2eTask9()
    lesson2eTask10()
}

/*
Создайте список чисел от 1 до 10, затем используйте метод filter чтобы оставить только четные числа.
После этого используйте метод map чтобы умножить каждое число на 2.
*/
fun lesson2eTask1() {
    println("Task 1: ")
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val doubledNumbers = numbers.filter { it % 2 == 0 }.map { it * 2 }
    println("doubled even numbers from 1 to 10: $doubledNumbers") //[4, 8, 12, 16, 20]
}

/*
Создайте список строк [“один”, “два”, “три”, “четыре”, “пять”].
Используйте map чтобы получить длину каждого элемента списка.
 */
fun lesson2eTask2() {
    println("Task 2: ")
    val stringNumbers = listOf("один", "два", "три", "четыре", "пять")
    val map = stringNumbers.map { it.length }
    println("Length's: $map") //[4, 3, 3, 6, 4]
}

/*
Напишите функцию высшего порядка, которая принимает два параметра: целое число и функцию,
принимающую целое число и возвращающую строку. Эта функция должна преобразовывать число
в строку с помощью переданной функции и возвращать результат.
 */
fun lesson2eTask3() {
    println("Task 3: ")
    val convert: (Int) -> String = { a -> a.toString() }
    val a = intToString(10, convert)
    println("${a::class}") // а - string

}

//ф-я высшего порядка
fun intToString(a: Int, operation: (Int) -> String): String {
    return operation(a)
}

/*
Создайте лямбда-функцию, которая принимает число и возвращает его квадрат.
Используйте эту лямбда-функцию в другой функции, которая принимает число и возвращает строку,
состоящую из числа и его квадрата (например, “5 и его квадрат равен 25”).
 */
fun lesson2eTask4() {
    println("Task 4: ")
    val squaredNumber: (Int) -> Int = { a -> a * a }
    println(getMsg(5, squaredNumber))

    val msgLambda: (Int) -> String = { a -> "squared $a == ${squaredNumber(a)}" }
    println(msgLambda(10))
}

//ф-я высшего порядка
fun getMsg(a: Int, operation: (Int) -> Int): String {
    return "squared $a == ${operation(a)}"
}

/*
Создайте объект класса Person со свойствами name и age.
Создайте список из нескольких таких объектов.
Используйте filter и map чтобы получить список имен тех людей, которым больше 18 лет.
 */
fun lesson2eTask5() {
    println("Task 5:")
    val persons = listOf<Person>(
        Person("Lena", 26),
        Person("Vasya", 16),
        Person("Katya", 22),
        Person("Kirill", 19),
        Person("Masha", 18),
        Person("Anna", 34)
    )

    val maturePeople = persons.filter { it.age > 18 }.map { it.name }
    println("Mature people: $maturePeople") //[Lena, Katya, Kirill, Anna]
}

data class Person(val name: String, val age: Int)

/*
Используя ленивые операции, создайте последовательность чисел от 1 до 1000,
затем используйте filter чтобы оставить только числа, делящиеся на 5,
затем map чтобы умножить каждое число на 2,
и take чтобы взять первые 20 элементов этой последовательности.
 */
fun lesson2eTask6() {
    println("Task 6:")
    val numbers = sequence {
        var i = 1
        while (i <= 1000) {
            yield(i++)
        }
    }
    val filteredNumbers = numbers
        .filter { it % 5 == 0 } //применяется последовательно к каждому эл-ту
        .map { it * 2 }

    val result = filteredNumbers
        .take(20)
        .toList()
    println(result) //[10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200]
}

/*
Создайте класс Car с полями make, model и year. Создайте коллекцию из нескольких объектов
этого класса и используйте groupBy чтобы сгруппировать машины по году выпуска.
 */
fun lesson2eTask7() {
    println("Task 7:")
    val cars = listOf(
        Car("Audi", "Q5", 2018),
        Car("Lada", "Largus", 2010),
        Car("BMW", "X5", 2024),
        Car("KIA", "Ceed", 2018),
        Car("Audi", "Q3", 2024),
        Car("Ford", "Focus", 2018)
    )
    val groupedCars = cars.groupBy { it.year }
    println(groupedCars)
}

data class Car(val make: String, val model: String, val year: Int)

/*
Создайте переменную lazyValue типа String, инициализируемую лениво.
Проверьте, что инициализация действительно происходит только при первом обращении к переменной.
 */
fun lesson2eTask8() {
    println("Task 8:")
    val lazyValue: String by lazy {
        println("Инициализация...")
        "значение"
    }
    println(lazyValue)
    println(lazyValue)
    println(lazyValue)

}

/*
Создайте функцию высшего порядка calculate, которая принимает два целых числа и функцию операции.
Продемонстрируйте использование calculate с разными операциями (сложение, вычитание, умножение).
 */
fun lesson2eTask9() {
    println("Task 9:")
    val add = { a: Int, b: Int -> a + b }
    val subtract = { a: Int, b: Int -> a - b }
    val multiply = { a: Int, b: Int -> a * b }

    println(calculate(1, 2, add)) //3
    println(calculate(5, 2, subtract)) //3
    println(calculate(2, 3, multiply)) //6
}

fun calculate(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

/*
Создайте коллекцию чисел и используйте fold или reduce чтобы посчитать их сумму,
минимальное и максимальное значения.
 */
fun lesson2eTask10() {
    println("Task 10:")
    val numbers = listOf(1, 2, 3, -10, 0, 4, 5, 6, -1)
    val sum = numbers.reduce { acc, i -> acc + i }
    val max = numbers.reduce { acc, i -> if (acc > i) acc else i }
    val min = numbers.reduce { acc, i -> if (acc < i) acc else i }
    println("numbers = $numbers")
    println("\t sum = $sum") //10
    println("\t max = $max") //6
    println("\t min = $min") //-10
}