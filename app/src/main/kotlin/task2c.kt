fun main() {

    //Задание 1: Создайте функцию maxOfTwo, которая принимает два числа в качестве аргументов
    // и возвращает наибольшее число. Затем, используйте эту функцию для поиска максимального числа
    // из двух разных пар чисел.

    /**
     * @param a целое число
     * @param b целое число
     * @return наибольшее из переданных параметров
     */
    fun maxOfTwo(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }
    //пары (a,b) (c,d)
    val a = 4
    val b = 1
    val c = -3
    val d = 8
    //максимальное число из максимумов из двух пар значений
    println(maxOfTwo(maxOfTwo(a, b), maxOfTwo(c, d)))

    //Задание 2: Создайте функцию sayHello, которая принимает строковый аргумент name и возвращает
    // приветственное сообщение. Функция должна иметь параметр по умолчанию "мир". Затем вызовите
    // функцию дважды: с именем и без имени.

    fun sayHello(name: String = "мир") {
        println("Привет, $name!!!")
    }
    sayHello("Вася")
    sayHello()

    //Задание 3: Создайте инфиксную функцию isGreater , которая принимает два числа
    // и возвращает true, если первое число больше второго, и false в противном случае.
    // Затем используйте эту функцию, сравнив две пары чисел.
    infix fun Int.isGreater(other: Int): Boolean {
        return this > other
    }

    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    //большее из пары (a,b)
//    if (a isGreater b) {
//        max1 = a
//    } else max1 = b
    max1 = if (a isGreater b) {
        a
    } else b
    //большее из пары (c,d)
    max2 = if (c isGreater d) {
        c
    } else d
    //большее из max(a,b) и max(c,d)
    if (max1 isGreater max2) {
        println(max1)
    } else println(max2)

    //Задание 4: Создайте рекурсивную функцию generateSequence, которая принимает целое число n
    // и генерирует последовательность чисел от 1 до n.
    // Используйте аннотацию tailrec для оптимизации.

    tailrec fun genSequence(n: Int, i: Int = 1, str: String=""): String {
        //останавливаемся когда дошли до <= 0
//        if (n <= 0) {
//            return i
//        }
        //print("$i ")

        //return genSequence(n-1, i+1)
        return if (i>n) { str.trim()} else {
            genSequence(n, i+1, "$str$i ")
        }
    }

    println(genSequence(5))

    //Задание 5: Создайте список имен и используйте функции let, run, also, apply и with для выполнения
    // различных операций над этим списком (например, добавьте имя, удалите имя, переверните список и т. д.).

    var names = mutableListOf("Елена","Лера", "Даша", "Настя", "Кирилл", "Вася")
    println(names)
    //let
    names.let{
        it.add("Женя")
        println("После добавления Жени: $it")
    }

    println()
    //run
    names.run {
        add("Маша")
        remove("Лера")
        println("Список после добавления Маши и удаления Леры: $this")
        println("Перевернутый список ${reversed()}")
    }
    println()
    //also
    names.also {
        println("Удалим Настю из списка и сделаем второе име капсом")
        it[1] = it[1].uppercase()
        it.remove("Настя")
    }.add("Nastya")
    println()

    //apply
    names.apply {
        println("До сортировки и добавления Виталия $this")
        sort()
        add("Виталий")
        add("Аня")
        removeFirst()
        println("После сортировки,добавления Виталия и Ани,удаление первого: $this")
    }
    println()
    //with
    with(names) {
        println("До изменения $this")
        removeAt(2)
        removeAll {  it.length > 4 }
        println("После удаления третьего и длиннее 4: $this")
    }


}


