import kotlin.math.log10
import kotlin.math.roundToInt

fun main() {
    println("Inserte sus datos para calcular la grasa")

    print("Altura (en cm): ")
    val height = readln().toDouble()

    print("Peso (en kg): ")
    val weight = readln().toDouble()

    print("Cintura (la medida en cm): ")
    val waist = readln().toDouble()

    print("Cuello (la medida en cm): ")
    val neck = readln().toDouble()

    println()

    var porcentageDeGrasa = (495 / (1.0324-0.19077 * log10((waist - neck)) + 0.15456 * log10(height)) - 450)

    porcentageDeGrasa = (porcentageDeGrasa * 100.0).roundToInt() / 100.0
    println("Porcentaje de Grasa: $porcentageDeGrasa")

    val fat = (((porcentageDeGrasa * weight) / 100.0) * 100.0).roundToInt() / 100.0
    println("Cantidad de grasa: $fat kg")

    val muscle = weight - fat
    println("Cantidad de musculo: $muscle kg")
}