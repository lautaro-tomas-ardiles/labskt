package calculadora

import kotlin.math.pow
import kotlin.math.sqrt

private fun calculate(x: String): Double {
    val numbers = mutableListOf<Double>()
    val operators = mutableListOf<Char>()
    var num = ""

    // Separar números y operadores
    for (i in x) {
        if (i.isDigit() || i == '.' || i == 'a') { // Considerar números decimales y negativos
            num += i
        } else {
            if (num.isNotEmpty()) {
                numbers.add(num.toDouble())
                num = ""
            }
            operators.add(i)
        }
    }
    if (num.isNotEmpty()) {
        numbers.add(num.toDouble())
    }

    //Resolver potencias
    val numberSize = numbers.size
    var indexPow = 0
    while (indexPow < operators.size){
        when (operators[indexPow]) {
        '^' -> {
            // Verificar que hay suficientes números
            if (indexPow + 1 < numberSize) {
                val result = numbers[indexPow].pow(numbers[indexPow + 1])

                // Actualizar las listas
                numbers[indexPow] = result
                numbers.removeAt(indexPow + 1)
                operators.removeAt(indexPow)
            } else {
                throw IndexOutOfBoundsException("No hay suficientes números para la operación de potencia.")
            }
        }

            '√' -> {
                if (numberSize > operators.size) {  //Correct position
                    val result = sqrt(numbers[indexPow + 1])
                    numbers[indexPow + 1] = result
                    operators.removeAt(indexPow) // remover la operacion
                    operators.add(indexPow,'*')

                } else {
                    val result = sqrt(numbers[indexPow])
                    numbers[indexPow] = result
                    operators.removeAt(indexPow)
                }
            }

            else -> {
                // Si no es un operador conocido, avanzar al siguiente índice
                indexPow++
        }
    }
    }

    // Resolver multiplicaciones y divisiones
    var index = 0
    while (index < operators.size) {
        if (operators[index] == '*' || operators[index] == '/') {
            val result = if (operators[index] == '*') {
                numbers[index] * numbers[index + 1]
            } else {
                numbers[index] / numbers[index + 1]
            }
            numbers[index] = result
            numbers.removeAt(index + 1) // Eliminar el segundo número ya procesado
            operators.removeAt(index) // Eliminar el operador ya procesado
        } else {
            index++
        }
    }

    // Resolver sumas y restas
    var equation = numbers[0]
    for (i in operators.indices) {
        equation = if (operators[i] == '+') {
            equation + numbers[i + 1]
        } else {
            equation - numbers[i + 1]
        }
    }

    return equation
}


fun main(){
    println(calculate("5√25")) // 25.0
    println(calculate("2+5√10")) // 17.16227766016838
    println(calculate("3*3-√12")) // 10.392304845413264
    println(calculate("√16+√9-5^3")) // 132.0
    println(calculate("3^6/3^4√497^1")) // 5822.0
//    println(calculate("8^2*-8√100+√64")) // 502.0
//    println(calculate("12^8/12^7+16^3/8^3+√121")) // 31.0
    println("Errores: considera 4- -4- como negativos")
}
