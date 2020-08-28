import kotlin.math.ceil
import kotlin.math.roundToInt
import kotlin.math.sqrt

class Matriz(val msg: String) {
    val tam: Int = msg.length.toDouble().let { ceil(sqrt(it)) }.toInt()
    var dados: Array<CharArray> = Array(tam) { CharArray(tam) }

    override fun toString(): String {
        var res:StringBuilder = StringBuilder(tam*tam + tam + 1)
        res.append('\n')
        for (i in 0 until tam) {
            for (j in 0 until tam)
                res.append(dados[i][j])
            res.append('\n')
        }
        return String(res)
    }

    init {
        var cursor = 0
        for (i in 0 until tam)
            for (j in 0 until tam) {
                dados[i][j] = msg.getOrElse(cursor, { '*' })
                cursor = cursor + 1
            }
    }

    fun gira(): Matriz {
        val res = Matriz(msg)
        for (i in 0 until tam)
            for (j in 0 until tam)
                res.dados[i][j] = dados[tam-1 - j][i]
        return res
    }

    fun extrai(): String {
        var res:StringBuilder = StringBuilder(msg.length)
        for (i in 0 until tam)
            for (j in 0 until tam)
                if (dados[i][j] != '*')
                    res.append(dados[i][j])
        return String(res)
    }
}

fun segredo(msg: String): String = Matriz(msg).gira().extrai()