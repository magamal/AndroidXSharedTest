package net.orgiu.weightwatcher

import assertk.assertThat
import assertk.assertions.containsOnly
import assertk.assertions.isNullOrEmpty
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import net.orgiu.weightwatcher.storage.WeightStorage
import org.junit.Test
import org.threeten.bp.Instant

class WeightRepositoryTest {

    private val mockStorage: WeightStorage = mock()
    private val repository = WeightRepository(mockStorage)

    @Test
    fun verify_data_is_added_properly() {
        val input = Weight(1f, Instant.ofEpochSecond(1566821825))
        repository.addWeight(input)
        verify(mockStorage).save(listOf(input))
    }

    @Test
    fun verify_repository_is_empty_at_the_beginning() {
        val input = repository.fetchUiModels()
        assertThat(input).isNullOrEmpty()
    }

    @Test
    fun verify_data_is_restored_properly() {
        val input = Weight(1f, Instant.ofEpochSecond(1566821825))

        whenever(mockStorage.fetch()).thenReturn(listOf(input))

        val actual = repository.fetchUiModels()

        assertThat(actual).containsOnly(input.toUiModule())
    }

}