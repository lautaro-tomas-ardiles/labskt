fun main() {

    val words = mutableListOf<String>()

    val dictionaryMorse = listOf(".-","-...","-.-.","-..",".","..-.","--.","....",
            "..",".---","-.-",".-..","--","-.","---",".--.","--.-",
            ".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    )

    val dictionary = listOf("a","b","c","d","e","f","g","h","i","j",
            "k","l","m","n","o","p","q","r","s","t","u",
            "v","w","x","y","z"
    )

    val translate = StringBuilder()

    print("¿vas a traducir morse a letras? (si | no) : ")
    val morse = readln()

    do {
        print("ingresa la letra : ")
        val word = readln()

        print("¿queries parar o continuar?(c para continuar, presiona cualquier otra tecla para parar) : ")
        val state = readln()

        words.add(word)

    }while (state == "c")

    when (morse) {
        "si" -> {
            for (x in words) {
                val index = dictionaryMorse.indexOf(x)
                if (index != -1) {
                    translate.append(dictionary[index] + "  ,   ")
                }else{
                    print("error una de las entradas no esta en el dicionario  ")
                }
            }

            println("$translate")
        }
        "no" -> {
            for (x in words) {
                val index = dictionary.indexOf(x)
                if (index != -1) {
                    translate.append(dictionaryMorse[index] + "  ,   ")
                }else{
                    print("error una de las entradas no esta en el dicionario ")
                }
            }

            println("$translate")
        }
        else -> {
            print("las posibles entradas son si o no")
        }
    }
}
