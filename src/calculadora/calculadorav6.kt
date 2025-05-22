package calculadora

import kotlin.math.pow
import kotlin.math.sqrt

private fun calculate(x: String): Float {
    val numbers = mutableListOf<Float>()
    val operators = mutableListOf<Char>()
    var num = ""
    var previousChar: Char? = null

    // Separar números y operadores
    for (i in x) {
        if (i.isDigit() ||
            (i == '-' && (previousChar == null || !previousChar.isDigit())) ||
            (i == '.' && num.isNotEmpty() && num.last().isDigit())
        ) { // Considerar números decimales y negativos
            num += i
        } else {
            if (num.isNotEmpty()) {
                numbers.add(num.toFloat())
                num = ""
            }
            if (i in "+-*/^√()") {
                operators.add(i)
            }
        }
        previousChar = i
    }
    if (num.isNotEmpty()) {
        numbers.add(num.toFloat())
    }

    var index = 0
    while (index < operators.size) {
        when (operators[index]) {
            '√' -> {
                if (numbers.size > operators.size) {  //Correct position
                    val result = sqrt(numbers[index + 1])
                    numbers[index + 1] = result
                    operators.removeAt(index) // remover la operacion
                    operators.add(index, '*')

                } else {
                    val result = sqrt(numbers[index])
                    numbers[index] = result
                    operators.removeAt(index)
                }
            }

            '^' -> {
                if (index + 1 < numbers.size) {
                    val result = numbers[index].pow(numbers[index + 1])
                    numbers[index] = result
                    numbers.removeAt(index + 1)
                    operators.removeAt(index) // Eliminar el operador
                } else {
                    throw IndexOutOfBoundsException("No hay suficientes números para la operación de potencia.")
                }
            }

            else -> index++ // Para operadores no reconocidos
        }
    }

    var index2 = 0
    while (index2 < operators.size) {
        when (operators[index2]) {

            '*' -> {
                if (index2 + 1 < numbers.size) {
                    val result = numbers[index2] * numbers[index2 + 1]
                    numbers[index2] = result
                    numbers.removeAt(index2 + 1)
                    operators.removeAt(index2)
                } else {
                    throw IndexOutOfBoundsException("No hay suficientes números para la multiplicación.")
                }
            }

            '/' -> {
                if (index2 + 1 < numbers.size) {
                    try {
                        val result = numbers[index2] / numbers[index2 + 1]
                        numbers[index2] = result
                        numbers.removeAt(index2 + 1)
                        operators.removeAt(index2)
                    } catch (e: ArithmeticException) {
                        e.printStackTrace()
                        println(e.message)
                    }
                } else {
                    throw IndexOutOfBoundsException("No hay suficientes números para la división.")
                }
            }

            else -> index2++ // Para operadores no reconocidos
        }
    }

    var index3 = 0
    while (index3 < operators.size) {
        when (operators[index3]) {
            '+' -> {
                if (index3 + 1 < numbers.size) {
                    val result = numbers[index3] + numbers[index3 + 1]
                    numbers[index3] = result
                    numbers.removeAt(index3 + 1)
                    operators.removeAt(index3)
                } else {
                    throw IndexOutOfBoundsException("No hay suficientes números para la suma.")
                }
            }

            '-' -> {
                if (index3 + 1 < numbers.size) {
                    val result = numbers[index3] - numbers[index3 + 1]
                    numbers[index3] = result
                    numbers.removeAt(index3 + 1)
                    operators.removeAt(index3)
                } else {
                    throw IndexOutOfBoundsException("No hay suficientes números para la resta.")
                }
            }

            else -> index3++ // Para operadores no reconocidos
        }
    }

    // Solo debería quedar un número al final
    return numbers.firstOrNull() ?: throw IllegalStateException("Error en la expresión.")
}

fun main(){
/*
    println(calculate("1+2")) // Resultado esperado: 3.0
    println(calculate("-15+22")) // Resultado esperado: 7.0

    println(calculate("-20-1")) // Resultado esperado: -21.0
    println(calculate("12-10")) // Resultado esperado: 2.0

    println(calculate("-15*22")) // Resultado esperado: -330.0
    println(calculate("20*2")) // Resultado esperado: 40.0
    println(calculate("-20*-2")) // Resultado esperado: 40.0

    println(calculate("1/2")) // Resultado esperado: 0.5
    println(calculate("-15/-22")) // Resultado esperado: 0.6818181818181818 (aproximadamente)
    println(calculate("-20/10")) // Resultado esperado: -2.0

    println(calculate("2^2")) // Resultado esperado: 4.0
    println(calculate("-15^-22")) // Resultado esperado: 3.0517578125E-11 (aproximadamente)
    println(calculate("-20^10")) // Resultado esperado: -10240000000000.0

    println(calculate("√25")) //5
    println(calculate("5√25")) //25

    println(calculate("12^8/12^7+16^3/8^3+√121"))
    println(calculate("8^2*-8√100+√64"))

 */

//    println(calculate("12^8/12^7+16^3/8^3+√121"))
//    println( (12.0.pow(8.0)/12.0.pow(7)) + (16.0.pow(3)/8.0.pow(3)) + sqrt(121.0) )// 8/12^7+16^3/8^3+√121)
//    println(calculate("429981696/35831808+4096/512+11"))
//    println(429981696/35831808+4096/512+11)
//    println(calculate("12+8+11"))

val a = calculate("6+10*2+5*2+2*4+1.5*4")
    println(if (a % 1 == 0.0f && a < Int.MAX_VALUE) a.toInt() else a)
}
