package calculadora

import kotlin.math.pow
import kotlin.math.sqrt

private fun orden(operators: MutableList<Char>, numbers: MutableList<Double>): MutableList<Double> {
    var index = 0
    while (index < operators.size) {
        when (operators[index]) {
            '√' -> {
                if (numbers.size > operators.size) {  // Correct position
                    val result = sqrt(numbers[index + 1])
                    numbers[index + 1] = result
                    operators.removeAt(index) // Remove the operation
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
                    operators.removeAt(index) // Remove the operator
                } else {
                    throw IndexOutOfBoundsException("Not enough numbers for the power operation.")
                }
            }
            '*' -> {
                if (index + 1 < numbers.size) {
                    val result = numbers[index] * numbers[index + 1]
                    numbers[index] = result
                    numbers.removeAt(index + 1)
                    operators.removeAt(index)
                } else {
                    throw IndexOutOfBoundsException("Not enough numbers for multiplication.")
                }
            }
            '/' -> {
                if (index + 1 < numbers.size) {
                    try {
                        val result = numbers[index] / numbers[index + 1]
                        numbers[index] = result
                        numbers.removeAt(index + 1)
                        operators.removeAt(index)
                    } catch (e: ArithmeticException) {
                        e.printStackTrace()
                        println(e.message)
                    }
                } else {
                    throw IndexOutOfBoundsException("Not enough numbers for division.")
                }
            }
            '+' -> {
                if (index + 1 < numbers.size) {
                    val result = numbers[index] + numbers[index + 1]
                    numbers[index] = result
                    numbers.removeAt(index + 1)
                    operators.removeAt(index)
                } else {
                    throw IndexOutOfBoundsException("Not enough numbers for addition.")
                }
            }
            '-' -> {
                if (index + 1 < numbers.size) {
                    val result = numbers[index] - numbers[index + 1]
                    numbers[index] = result
                    numbers.removeAt(index + 1)
                    operators.removeAt(index)
                } else {
                    throw IndexOutOfBoundsException("Not enough numbers for subtraction.")
                }
            }
            else -> index++ // For unrecognized Operators
        }
    }
    return numbers
}

private fun handleParentheses(expression: String): Double {
    val numbers = mutableListOf<Double>()
    val operators = mutableListOf<Char>()
    var num = ""
    var previousChar: Char? = null

    var index = 0
    var insideParentheses = false

    while (index < expression.length) {
        val char = expression[index]

        when {
            char == '(' -> {
                // Cuando encontramos un paréntesis de apertura, procesamos lo que hay dentro
                val closingParenthesisIndex = findClosingParenthesis(expression, index)
                val subExpression = expression.substring(index + 1, closingParenthesisIndex)
                val result = handleParentheses(subExpression)
                numbers.add(result)
                index = closingParenthesisIndex // Avanzamos al final del paréntesis
            }
            char == ')' -> return handleParentheses(expression.substring(index + 1)) // Recursivo
            char.isDigit() || char == '.' || (char == '-' && (previousChar == null || !previousChar.isDigit())) -> {
                num += char
            }
            else -> {
                if (num.isNotEmpty()) {
                    numbers.add(num.toDouble())
                    num = ""
                }
                if (char in "+-*/^√") {
                    operators.add(char)
                }
            }
        }
        previousChar = char
        index++
    }

    if (num.isNotEmpty()) {
        numbers.add(num.toDouble())
    }

    return orden(operators, numbers).firstOrNull() ?: throw IllegalStateException("Error in the expression.")
}

private fun findClosingParenthesis(expression: String, openIndex: Int): Int {
    var balance = 1
    var index = openIndex + 1
    while (index < expression.length && balance > 0) {
        when (expression[index]) {
            '(' -> balance++
            ')' -> balance--
        }
        index++
    }
    return index - 1
}

private fun calculate(x: String): Double {
    // Quitar los espacios en blanco y procesar los paréntesis
    val trimmedExpression = x.replace(" ", "")

    return handleParentheses(trimmedExpression)
}

fun main() {
    println(calculate("1 + 2 * (3 + 4)"))  // Resultado esperado: 15.0
    println(calculate("3 + (5 * 2)"))      // Resultado esperado: 13.0
    println(calculate("√(25 + 5)"))        // Resultado esperado: 5.477225575051661
    println(calculate("((2 + 3) * 4)"))    // Resultado esperado: 20.0
    println(calculate("5√25")) // 25.0
     println(calculate("2+5√10")) // 17.16227766016838
     println(calculate("3*3-√12")) // 10.392304845413264
     println(calculate("√16+√9-5^3")) // 132.0
     println(calculate("3^6/3^4√497^1")) // 5822.0
     println(calculate("8^2*-8√100+√64")) // 502.0
     println(calculate("12^8/12^7+16^3/8^3+√121")) // 31.0
}
