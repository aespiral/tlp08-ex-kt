import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestesFrio: StringSpec({
    "um valor negativo" {
        frio(5, -10, 15) shouldBe 1
    }

    "todos negativos" {
        frio(-14, -5, -39, -5, -7) shouldBe 5
    }

    "nenhum negativo" {
        frio(15, 10, 29, 31, 19, 22) shouldBe 0
    }
})