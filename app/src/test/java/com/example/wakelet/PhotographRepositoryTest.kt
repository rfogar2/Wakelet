package com.example.wakelet

import com.example.wakelet.dtos.PhotographDto
import com.example.wakelet.models.Photograph
import com.example.wakelet.repositories.PhotographRepositoryImpl
import com.example.wakelet.stubs.PhotographServiceStub
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class PhotographRepositoryTest {
    private lateinit var photographServiceStub: PhotographServiceStub
    private lateinit var photographRepositoryImpl: PhotographRepositoryImpl

    @Before
    fun setup() {
        photographServiceStub = PhotographServiceStub()
        photographRepositoryImpl = PhotographRepositoryImpl(photographServiceStub)
    }

    @Test
    fun `converts dtos to models with nonnull bio`() {
        val dto = PhotographDto("image", "description", "name", "bio")

        photographServiceStub.photographDtos = listOf(dto)

        val actual = photographRepositoryImpl.getPhotographs().blockingGet()
        val expected = listOf(Photograph("image", "description", "name", "bio"))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `converts dtos to models with null bio`() {
        val dto = PhotographDto("image", "description", "name", null)

        photographServiceStub.photographDtos = listOf(dto)

        val actual = photographRepositoryImpl.getPhotographs().blockingGet()
        val expected = listOf(Photograph("image", "description", "name", null))
        assertThat(actual).isEqualTo(expected)
    }
}