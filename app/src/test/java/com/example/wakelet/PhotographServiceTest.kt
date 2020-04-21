package com.example.wakelet

import com.example.wakelet.services.PhotographServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PhotographServiceTest {
    @Test
    fun `parses json to get correct number of photograph dtos`() {
        val service = PhotographServiceImpl()

        val photographDtos = service.getPhotographs().blockingGet()
        assertThat(photographDtos.size).isEqualTo(12)
    }
}