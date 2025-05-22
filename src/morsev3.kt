fun main(){

    val dictionaryMorse = listOf(
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
        "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
        ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    )

    val dictionary = "abcdefghijklmnopqrstuvwxyz"

    var translate = ""

    println("¿vas a traducir morse a letras? (si | no) (si lo hace sepárelas con ,) : ")
    val morse = readln()

    println("ingrese el texto a transformar")
    val texts = readln()

    when (morse) {
        "no" -> {
            for (x in texts) {
                val index = dictionary.indexOf(x)// indice de la letra

                if (index != -1) {
                    translate += dictionaryMorse[index] + " , "
                } else {
                    print("error una de las entradas no esta en el dicionario ")
                }
            }

            println(translate)
        }

        "si" -> {
            val newTexts = texts.split(',')

            for (x in newTexts) {
                val index = dictionaryMorse.indexOf(x)// indice de la letra

                if (index != -1) {
                    translate += dictionary[index]
                } else {
                    print("error una de las entradas no esta en el dicionario ")
                }
            }

            println(translate)
        }

        else -> {
            print("las posibles entradas son si o no")
        }
    }
}