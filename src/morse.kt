fun main() {
    val words = mutableListOf<String>()

    print("are you going to use morse? ( si | no ): ")
    val morse = readln()

    if (morse == "si") {
        do {
            print("Enter a letter:")
            val word = readln()

            print("Do you want to continue or stop? (c to continue, any other key to stop): ")
            val cob = readln()

            words.add(word)

        } while (cob == "c")

        val dictionaryMorse = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        val dictionary = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")

        val translate = StringBuilder()

        for (x in words) {
            val index = dictionaryMorse.indexOf(x)
            if (index != -1) {
                translate.append(dictionary[index])
            }
        }
        println(translate.toString())

    }else if (morse == "no") {
        do {
            print("Enter a letter:")
            val word = readln()

            print("Do you want to continue or stop? (c to continue, any other key to stop): ")
            val cob = readln()

            words.add(word)

        } while (cob == "c")

        val dictionaryMorse = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        val dictionary = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")

        val translate = StringBuilder()

        for (x in words) {
            val index = dictionary.indexOf(x)
            if (index != -1) {
                translate.append(dictionaryMorse[index])
            }
        }
        println(translate.toString())
    }
}