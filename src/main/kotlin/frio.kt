
fun frio(vararg temps: Int): Int = temps.filter { it < 0 }.size

// para submissão no Kattis
fun main() {
    val n = readLine()?.toInt() ?: 0
    val result = ArrayList<Int>()
    repeat(n) {
        result.add(readLine()?.toInt() ?: 1000)
    }
    println(frio(*result.toIntArray()).toString())
}