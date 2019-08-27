package net.orgiu.weightwatcher.storage

import net.orgiu.weightwatcher.UiModel
import net.orgiu.weightwatcher.Weight
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle
import java.util.*

class WeightParser : Parser<Weight, UiModel> {
    private val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        .withLocale(Locale.ITALY)
        .withZone(ZoneId.systemDefault())

    override fun map(input: Weight): UiModel =
        UiModel(weight = "${input.value} KG", timestamp = formatter.format(input.timestamp))
}