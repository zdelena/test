import kotlin.math.PI

fun main() {
    /*
    1. Создайте класс Car с полями model, color, year и методом drive().
    Создайте несколько объектов этого класса и вызовите их метод drive().
     */
    oopTask1()
    println()

    /*
    2. Создайте enum class DayOfWeek, содержащий все дни недели.
    Выведите все дни недели, используя свойства values и name этого enum.
     */
    oopTask2()
    println()

    /*
    3. Создайте объект Singleton с методом printMessage(),
    который выводит любое сообщение. Вызовите этот метод.
     */
    oopTask3()
    println()

    /*
    4. Создайте класс Person с приватными свойствами name, age
    и публичными методами getName() и getAge().
    Проверьте, что прямой доступ к этим свойствам невозможен извне класса.
     */
    oopTask4()
    println()

    /*
    5. В классе Person добавьте custom геттеры и сеттеры для свойств name и age.
    Убедитесь, что вы можете управлять доступом к этим свойствам извне класса.
    Например, вы можете реализовать проверку возраста в сеттере, чтобы убедиться,
    что возраст неотрицательный.
     */
    oopTask5()
    //println("Person ${person2.name} of age ${person2.age}")
    println()

    /*
    6. Создайте класс Animal с методом makeSound(), затем создайте классы Dog и Cat,
    наследующие от Animal, и переопределите метод makeSound().
    Создайте объекты Dog и Cat и вызовите их методы makeSound().
     */
    oopTask6()
    println()

    /*
    7. Создайте класс MathUtils и перегрузите функцию add(),
    чтобы она могла принимать два или три целых числа.
     */
    oopTask7()
    println()

    /*
    Создайте абстрактный класс Shape с абстрактным методом area(),
    затем создайте классы Circle и Rectangle, реализующие этот метод.
    Создайте объекты Circle и Rectangle и выведите их площадь.
     */
    oopTask8()
    println()

    /*
    Создайте интерфейс Flyable с методом fly() и интерфейс Navigable  с методом navigate(),
    затем создайте классы Bird и Airplane, реализующие эти интерфейсы.
    Создайте объекты Bird и Airplane и вызовите их методы fly() и navigate().
     */
    oopTask9()
    println()

    /*
    10. Создайте data class User с двумя свойствами и методом printInfo(),
    который выводит информацию о пользователе. Создайте объект User и вызовите его метод printInfo().
     */
    oopTask10()
    println()

    /*
    Создайте sealed class MathOperation и несколько объектов, представляющих различные
    математические операции (например, Add, Subtract, Multiply, Divide).
    Создайте функцию, которая принимает MathOperation и два числа, и выполняет соответствующую операцию.
     */
    oopTask11()
    println()

    /*
    12. Создайте два класса: Mammal и CanFly. В классе Mammal определите метод breastfeed(),
    а в классе CanFly - метод fly(). Затем создайте класс Bat, который сочетает в себе
    оба этих поведения (с помощью композиции).
     */
    oopTask12()
    println()
}

fun oopTask1() {
    println("Task 1: ")
    val myCar = Car("Audi", "white", 2017)
    val myCar2 = Car("BMW", "black", 2018)
    val myCar3 = Car("Lada", "red", 2001)
    myCar.drive()
    myCar2.drive()
    myCar3.drive()
}

//основной контруктор принимает три параметра - model, color, year
class Car(private var model: String, private var color: String, private var year: Int) {
    fun drive() {
        println("Car $model ($color, $year) drives")
    }
}

fun oopTask2() {
    println("Task 2: ")
    for (day in DaysOfWeek.values()) {
        print("${day.name} ")
    }
    println()
}

enum class DaysOfWeek() {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

fun oopTask3() {
    println("Task 3: ")
    Singleton.printMessage("hello")
    Singleton.printMessage()
}

//Singleton объект - это объект, который имеет только один экземпляр в JVM
object Singleton {
    fun printMessage(msg: String = "Some message") {
        println(msg)
    }
}

fun oopTask4() {
    println("Task 4: ")
    val person = PersonPrivateFields()
    //println("Person ${person.name} of age ${person.age}") //ошибка
    println("Person ${person.getName()} of age ${person.getAge()}")
}

class PersonPrivateFields {
    private var name: String = "Unknown"
    private var age: Int = 0

    fun getName(): String {
        return this.name
    }

    fun getAge(): Int {
        return this.age
    }
}

fun oopTask5() {
    println("Task 5: ")

    val person = Person()
    person.apply {
        name = "Lena"
        age = 26
        println("\tPerson ${this.name} of age ${this.age}")
    }

    val person2 = Person()
    person2.apply {
        name = "   "
        age = -2
        println("\tPerson ${this.name} of age ${this.age}")
    }
}

class Person {
    var name: String = "Unknown"
        set(value) {
            if (value.trim().isNotEmpty()) {
                println("Setting name to $value")
                field = value
            } else {
                println("Name should be not empty")
            }
        }
        get() {
            return field
        }
    var age: Int = 0
        set(value) {
            if (value > 0) {
                println("Setting age to $value")
                field = value
            } else {
                println("Age must be > 0")
            }
        }
        get() {
            return field
        }
}

fun oopTask6() {
    println("Task 6:")
    val cat = Cat()
    cat.makeSound()

    val dog = Dog()
    dog.makeSound()
}

//open - доступен для наследования
open class Animal {
    open fun makeSound() {
        println("Animal makes a sound")
    }
}

class Cat : Animal() {
    //переопределяем метод
    override fun makeSound() {
        println("meow-meow")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("woof-woof")
    }
}

fun oopTask7() {
    println("Task 7: ")
    val mathUtil = MathUtils()
    println(mathUtil.add(1, 2))
    println(mathUtil.add(1, 2, 3))
}

class MathUtils {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c
    }
}

fun oopTask8() {
    println("Task 8:")

    val circle = Circle(5.0)
    println("Circle's area = ${circle.area()}")

    val rectangle = Rectangle(2.0, 4.0)
    println("Rectangle's area = ${rectangle.area()}")
}

abstract class Shape {
    abstract fun area(): Double
}

class Circle(private val r: Double) : Shape() {
    override fun area(): Double {
        return PI * r * r
    }
}

class Rectangle(private val l: Double, private val w: Double) : Shape() {
    override fun area(): Double {
        return l * w
    }
}

fun oopTask9() {
    println("Task 9: ")
    val bird = Bird()
    bird.fly()
    bird.navigate()

    val plane = Airplane()
    plane.fly()
    plane.navigate()
}

interface Flyable {
    fun fly()
}

interface Navigable {
    fun navigate()
}

class Bird : Flyable, Navigable {
    override fun fly() {
        println("Bird is flyable")
    }

    override fun navigate() {
        println("Bird is navigable")
    }
}

class Airplane : Flyable, Navigable {
    override fun fly() {
        println("Airplane is flyable")
    }

    override fun navigate() {
        println("Airplane is navigable")
    }
}

fun oopTask10() {
    println("Task 10:")
    val user = User("Вася", 22)
    user.printInfo()
}

data class User(val name: String, val age: Int) {
    fun printInfo() {
        println("Name = $name, age = $age")
    }
}

fun oopTask11() {
    println("Task 11:")
    println(mathOperation(Add, 10.0, 3.0))
    println(mathOperation(Subtract, 10.0, 3.0))
    println(mathOperation(Multiply, 10.0, 3.0))
    println(mathOperation(Divide, 10.0, 3.0))
}

sealed class MathOperation
object Add : MathOperation()
object Subtract : MathOperation()
object Multiply : MathOperation()
object Divide : MathOperation()

fun mathOperation(op: MathOperation, a: Double, b: Double): Double {
    return when (op) {
        Add -> a + b
        Subtract -> a - b
        Multiply -> a * b
        Divide -> a / b
    }
}

fun oopTask12() {
    println("Task 12:")

    val bat = Bat()
    bat.doFly()
    bat.doBreastFeed()
}

open class Mammal {
    open fun breastfeed() {
        println("feeds with breast")
    }
}

open class CanFly {
    open fun fly() {
        println("can fly")
    }
}

class Bat() {
    private val mammal = Mammal()
    private val canFly = CanFly()

    fun doBreastFeed() {
        mammal.breastfeed()
    }

    fun doFly() {
        canFly.fly()
    }
}



















