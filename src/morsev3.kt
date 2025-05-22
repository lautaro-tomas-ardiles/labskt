fun main(){

    val dictionaryMorse = listOf(
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
        "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
        ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    )

    val dictionary = "abcdefghijklmnopqrstuvwxyz"

    var translate = ""

    println("ingrese el texto a transformar")
    val texts = readln()

    for (x in texts){
        val index = dictionary.indexOf(x)// indice de la letra

        if (index != -1) {
            translate += dictionaryMorse[index] + " , "
        }else{
            print("error una de las entradas no esta en el dicionario ")
        }
    }

    println(translate)
    
}