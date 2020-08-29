
fun frio(vararg temps: Long): Int = temps.filter { it < 0 }.size

// para submissão no Kattis
fun main() {
    val n = readLine()?.toInt() ?: 0
    val result: LongArray = LongArray(n)
    for (i in 0 until n)
        result[i] = readLine()?.toLong() ?: 1000
    println(frio(*result))
}