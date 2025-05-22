fun main() {

    print("primer numero : ")
    val num1 = readln().toInt()

    var num2 = num1 / 2

    num2 *= 2

    if (num2 == num1) {
        print("el numero es par")
    } else{
        print("el numero no es par")
    }
}