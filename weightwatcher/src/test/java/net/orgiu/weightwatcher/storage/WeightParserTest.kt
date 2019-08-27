package net.orgiu.weightwatcher.storage

import assertk.assertThat
import assertk.assertions.isEqualTo
import net.orgiu.weightwatcher.UiModel
import net.orgiu.weightwatcher.Weight
import org.junit.Test
import org.threeten.bp.Instant

class WeightParserTest {

    private val parser = WeightParser()

    @Test
    fun verify_weight_is_mapped_correctly_to_ui_model() {
        val weight = Weight(1f, Instant.ofEpochSecond(1566821825))
        val actual = parser.map(weight)

        val expected = UiModel("1.0 KG", "26-ago-2019 14.17.05")

        assertThat(actual).isEqualTo(expected)
    }
}