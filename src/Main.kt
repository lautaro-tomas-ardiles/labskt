import kotlin.math.roundToInt

fun main() {

    print(" insert the number of characters of the password : ")
    val numberLetters = readln().toInt()

    val letters ="abcdefghijklmnopqrstuvwxyz"
    val lettersMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val number = "0123456789"
    val simbls = "!@#$%^&*=+-/€<>)"

    var i = 1

    while (i <= numberLetters) {

        val numberAleatoryForLetter = (Math.random() * 25).roundToInt()
        val numberAleatoryForNumbers = (Math.random() * 9).roundToInt()
        val numberAleatoryForSymbols = (Math.random() * 15).roundToInt()

        val j = i / 2
        val k = j * 2

        if ( i <= 6 ) {
            if ( i == k || i == 1) {
                print(letters[numberAleatoryForLetter])
            }else {
                print(number[numberAleatoryForNumbers])
            }
        }else{
            if ( i == k ) {
                print(simbls[numberAleatoryForSymbols])
            }else {
                print(lettersMayus[numberAleatoryForLetter])
            }
        }
        i++
    }
}