package calculadora

fun main() {

    var r = 0.0

    print("parametro : ")
    val p = readln()

    print("primer numero : ")
    val num1 = readln().toDouble()

    print("segundo numero : ")
    val num2 = readln().toDouble()

    if (p == "+") {
        r = num1 + num2
        print(r)
    } else if (p == "-") {
        r = num1 - num2
        print(r)
    } else if (p == "*") {
        r = num1 * num2
        print(r)
    } else if (p == "/") {
        r = num1 / num2
        print(r)
    } else if (p == "^"){
        r = Math.pow(num1,num2)
        print(r)
    } else if (p == "$"){
        r = Math.sqrt(num1)
        print(r)
    }
}
