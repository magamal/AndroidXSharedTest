package net.orgiu.weightwatcher

import kotlinx.serialization.UnstableDefault
import net.orgiu.weightwatcher.storage.Parser
import net.orgiu.weightwatcher.storage.WeightParser
import net.orgiu.weightwatcher.storage.WeightStorage

@UnstableDefault
class WeightRepository(
    private val storage: WeightStorage,
    private val parser: Parser<Weight, UiModel> = WeightParser()
) {


    fun addWeight(weight: Weight) {
        val weights = storage.fetch().toMutableList()
        weights.add(weight)

        storage.save(weights)
    }

    fun fetchUiModels(): List<UiModel> =
        storage.fetch().map { parser.map(it) }

}