val matrix: MutableList<MutableList<Any?>> = mutableListOf()

fun min() {
    val x = mutableListOf<String>()

    do {
        println("ingrese una variable : ")
        x.add(readln())

        println("va a continuar : ")
        val z = readln()
    } while (z == "c")

    matrix.add(mutableListOf(x))

    println(matrix)
}

fun main() {
    for (i in 0..2) {
        min()
    }
}
