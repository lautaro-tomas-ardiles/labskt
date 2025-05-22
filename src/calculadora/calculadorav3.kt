package calculadora
fun main(){
    var entrada = readln()
    println(entrada)

    val num = entrada.split("+")
    println(num)

    var suma = 0.0

    for(i in num){
        val a = i.toDoubleOrNull()
        if (a != null) {
            suma += i.toDouble()

        }
    }
    println(suma)
}