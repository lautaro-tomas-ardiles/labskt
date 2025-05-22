fun main() {

    val a = listOf("1", "2", "3")
    var b = ""

    for (elements in a){
        b = a.joinToString(", ")
    }

    val c = b.split(", ")
    for (i in a){
        print(i)
    }
    println("")
    for (j in b){
        print(j)
    }
    println("")
    for (k in c){
        print(k)
    }
    println("")
    print(c.size)

    /**
    val yearsOld = 12
    /*
    if (yearsOld >= 18) {
    println("aception")
    }else {
    print("no")
    }
    */
    // es la opcion mas lenta
    if (yearsOld >= 18) {
    println("aception")
    }else if (yearsOld < 18) {
    print("no")
    }
     **/

}