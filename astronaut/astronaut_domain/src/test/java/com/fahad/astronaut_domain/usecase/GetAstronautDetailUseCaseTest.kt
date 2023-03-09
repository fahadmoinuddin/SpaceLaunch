package com.fahad.astronaut_domain.usecase

import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.core.common.Resource
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.util.*

class GetAstronautDetailUseCaseTest {

    private lateinit var getAstronautDetailsUseCase: GetAstronautDetailsUseCase

    @Before
    fun setup() {
        val repository = mockk<IAstronautRepository>(relaxed = true)
        every { runBlocking { repository.getAstronautDetail(1) } } returns Resource.Success(Astronaut(
            1,
            "abcd",
            "Australian",
            "Abcd is an astronaut",
            Date(),
            null
        ))
        getAstronautDetailsUseCase = GetAstronautDetailsUseCase(repository)
    }

    @Test
    fun `Astronaut Detail, valid id, Resource success`() = runBlocking {
        assertThat(getAstronautDetailsUseCase(1).last().data?.name).isEqualTo("abcd")
    }

    @Test
    fun `Astronaut Detail, invalid id, Resource error`() = runBlocking {
        assertThat(getAstronautDetailsUseCase(0).last().message).isEqualTo("id cannot be empty")
    }
}