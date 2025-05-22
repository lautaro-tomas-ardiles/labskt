import kotlin.system.measureTimeMillis

fun main() {

    val time = measureTimeMillis {

        print("insert the number of characters of the password : ")
        val numberLetters = readln().toInt()

        val options = "abcdefghijklmnopqrstuvwxyz|ABCDEFGHIJKLMNOPQRSTUVWXYZ|0123456789|!@#$%^&*=+-/€<>)"

        var result = ""

        for (i in 1..numberLetters) {

            //se selecciona un char random del string
            //result += options[(Math.random() * options.length).roundToInt()]
            result += options[options.indices.random()]

        }
        print(result)
    }
    print(time)
}