import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestesSecreto: StringSpec({
    "iloveyoutooJill" {
        segredo("iloveyoutooJill") shouldBe "iteiloylloooJuv"
    }

    "TheContestisOver" {
        segredo("TheContestisOver") shouldBe "OsoTvtnheiterseC"
    }

})