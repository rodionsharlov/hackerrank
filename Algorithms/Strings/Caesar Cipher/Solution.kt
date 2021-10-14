fun caesarCipher(s: String, k: Int): String {

    val low  = 'a'.code
    val upp  = 'A'.code

    return s.map {
        when (it.code) {
            in low..low + 25 -> (((it.code - low + k) % 26) + low).toChar()
            in upp..upp + 25 -> (((it.code - upp + k) % 26) + upp).toChar()
            else -> it
        }
    }.joinToString("")
}

// Old-style version with toByte() instead of .code
/*
fun caesarCipher(s: String, k: Int): String {

    val low  = 'a'.toByte()
    val upp  = 'A'.toByte()
    return s.map {
        when (it.toByte()) {
            in low..low + 25 -> (((it.toByte() - low + k) % 26) + low).toChar()
            in upp..upp + 25 -> (((it.toByte() - upp + k) % 26) + upp).toChar()
            else -> it
        }
    }.joinToString("")
}
*/

fun main() {
    println(caesarCipher("middle-Outz", 2))
//    okffng-Qwvb
//    okffng-Qwvb // expected output
}