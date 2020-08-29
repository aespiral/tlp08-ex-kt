
fun frio(vararg temps: Long): Int = temps.filter { it < 0 }.size

// para submissão no Kattis
fun main() {
    readLine()
    val dados = readLine()

    val result: LongArray
    if (dados != null) {
        result = dados.split(' ').map { it.toLong() }.toLongArray()
        println(frio(*result))
    }
}