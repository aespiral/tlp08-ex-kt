/*
 * Uma versão mais `funcional`, seguindo Richard Bird em `Thinking functionally with Haskell`
 *
 * Bird refuta o uso de índices (como em a[i]), pois eles dificultam composição, ou uma visão
 * do problema que favorece à composição.
 *
 * Vamos começar com a visualização das estapas intermediárias no fluxo do programa,
 * tendo como exemplo a string "helloFriend", que, tendo 11 letras, cabe em 4x4
 *
 * 1     "helloFriend"
 * 2     [h e l l o F r i e n d * * * * *]
 * 3   [ [h e l l] [o F r i] [e n d *] [* * * *] ]
 * 3.1 [ [h] [e] [l] [l] ]
 * 3.2 [ [h o] [e F] [l r] [l i] ]
 * 3.3 [ [h o e] [e F n] [l r d] [l i *] ]
 * 3.4 [ [h o e *] [e F n *] [l r d *] [l i * *] ]
 * 4   [ [* e o h] [* n F e] [* d r l] [* * i l] ]
 * 5   [ * e o h * n F e * d r l * * i l ]
 * 6   [ e o h n F e d r l i l ]
 * 7    "eohnFedrlil"
 *
 * Cada transição é uma função específica.
 *
 * 1     "helloFriend"
 * A String vira uma lista do tamanho desejado e é completada com '*'
 * str.toList().plus( List( tam*tam - str.length , { '*' })
 * 2     [h e l l o F r i e n d * * * * *]
 * A lista é segmentada listas menores de tamanho fixo tam
 *  lista.chunked(4)
 * 3   [ [h e l l] [o F r i] [e n d *] [* * * *] ]
 *  VER ABAIXO
 * 4   [ [* e o h] [* n F e] [* d r l] [* * i l] ]
 * lista-de-listas.flatten()
 * 5   [ * e o h * n F e * d r l * * i l ]
 * lista.filter { it != '*' }
 * 6   [ e o h n F e d r l i l ]
 * lista.let {String(it.toCharArray())
 * 7    "eohnFedrlil"
 *
 * DETALHAMENTO DO PASSO 3 -> 4
 * 3   [ [h e l l] [o F r i] [e n d *] [* * * *] ]
 * acc = [ [] [] [] [] ] lstnha= [h e l l] zip= [([],h) ([],e) ([],l) ([],l)]
 * 3.1 [ [h] [e] [l] [l] ]
 * acc = [ [h] [e] [l] [l] ] lstnha= [o F r i] zip= [([h],o) ([e],F) ([l],r) ([l],i)]
 * 3.2 [ [h o] [e F] [l r] [l i] ]
 * acc = [ [h o] [e F] [l r] [l i] ] lstnha= [e n d *] zip= [([h o],e) ([e F],n) ([l r],d) ([l i],*)]
 * 3.3 [ [h o e] [e F n] [l r d] [l i *] ]
 * acc = [ [h o e] [e F n] [l r d] [l i *] ] lstnha= [* * * *] zip= [([h o e],*) ([e F n],*) ([l r d],*) ([l i *],*) ]
 * 3.4 [ [h o e *] [e F n *] [l r d *] [l i * *] ]
 * ll.map( it.reversed() )
 * 4   [ [* e o h] [* n F e] [* d r l] [* * i l] ]
 *
 */
import kotlin.math.ceil
import kotlin.math.sqrt

fun segredo(msg: String): String {
    val tam: Int = msg.length.toDouble().let { ceil(sqrt(it)) }.toInt()
    val llvazia: List<List<Char>> = List(tam) { mutableListOf() }
    fun f(acc: List<List<Char>>, lstnha: List<Char>): List<List<Char>> =
            acc.zip(lstnha).map { (l, c) -> l.plus(listOf(c))}
    return msg
            .toList()
            .plus( List(tam*tam - msg.length, { '*' } ) )
            .chunked(tam)
            .fold(llvazia, ::f)
            .map { it.reversed() }
            .flatten()
            .filter { it != '*' }
            .let { String(it.toCharArray())}
}

fun main() {
    val n: Int = readLine()?.toInt()?:0
    val msgs: ArrayList<String> = ArrayList()
    for (i in 1..n)
        msgs.add( readLine() ?: "")

    msgs.map(::segredo).map(::println)
}