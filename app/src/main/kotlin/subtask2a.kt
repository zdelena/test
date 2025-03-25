/**
 * в функции запрашивается ввод из консоли,
 * который сохраняется в переменную и затем выводится на экран
 */
fun readout (){
    println("Введите имя ")
    val name = readLine().toString()
    println("Введите должность ")
    val job = readLine().toString()
    println("Ваше имя - $name, ваша должность - $job")
}