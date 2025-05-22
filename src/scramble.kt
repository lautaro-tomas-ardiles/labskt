
fun scrambleWords(words: List<String>): List<String> {
    return words.map { word ->
        word.toList().shuffled().joinToString("")
    }
}

fun main() {
    val words = listOf("hola", "chau", "mundo")
    val scrambledWords = scrambleWords(words)

    for (i in words.indices) {
        val scrambledWord = scrambledWords[i]

        var correct = false
        while (!correct) { // Loop until correct answer
            println(scrambledWord)
            println("ingrese la palabra ordenada")
            val answer = readln()

            if (answer == words[i]) {
                println("correcto")
                correct = true // Exit loop on correct answer
            } else {
                println("incorrecto")
            }
        }
    }
    println("victoria")
}