package calculadora

import java.lang.Math.pow
import kotlin.math.sqrt

fun main() {

    val r: Double
    var num1 = 0.0
    var num2 = 0.0

    print("parametro : ")
    val p = readln()

    if (p == "#"){
        print("primer numero : ")
        num1 = readln().toDouble()
    }else {
        print("primer numero : ")
        num1 = readln().toDouble()

        print("segundo numero : ")
        num2 = readln().toDouble()
    }

        when(p) {
            "+" -> {
                r = num1 + num2
                print("el resultado es: " + r)
            }
            "-" -> {
                r = num1 - num2
                print("el resultado es: " + r)
            }
            "*" -> {
                r = num1 * num2
                print("el resultado es: " + r)
            }
            "/" -> {
                r = num1 / num2
                print("el resultado es: " + r)
            }
            "!" -> {
                r = pow(num1, num2)
                print("el resultado es: " + r)
            }
            "#" -> {
                r = sqrt(num1)
                print("el resultado es: " + r)
            }
            else -> {
                print("los operadores son +,_,*,/")
            }
        }
}