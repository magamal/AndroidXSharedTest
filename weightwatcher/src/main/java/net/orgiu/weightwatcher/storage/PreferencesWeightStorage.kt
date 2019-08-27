package net.orgiu.weightwatcher.storage

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import net.orgiu.weightwatcher.Weight

@UnstableDefault
class PreferencesWeightStorage(context: Context) : WeightStorage {

    companion object {
        private const val STORAGE_KEY = "WeightData"
    }

    private val storage = PreferenceManager.getDefaultSharedPreferences(context)

    override fun save(weights: List<Weight>) {
        val json = Json.stringify(Weight.serializer().list, weights)
        storage.edit {
            putString(STORAGE_KEY, json)
        }
    }

    override fun fetch(): List<Weight> =
        storage.getString(STORAGE_KEY, null)?.let {
            Json.parse(Weight.serializer().list, it)
        }.orEmpty()
}