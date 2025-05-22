
fun main(){
    val palabras = mutableListOf<String>()

    do {
        print("ingresa un nombre : ")
        val palabra = readln()

        print("¿queries parar o continuar?(c para continuar, presiona cualquier otra tecla para parar) : ")
        val state = readln()

        palabras.add(palabra)

    }while (state == "c")

    println("$palabras")

    for (j in palabras.sorted()){
        println(j)
    }
}