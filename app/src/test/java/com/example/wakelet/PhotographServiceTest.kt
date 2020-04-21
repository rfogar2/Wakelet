package com.example.wakelet

import com.example.wakelet.services.PhotographService
import com.example.wakelet.services.PhotographServiceImpl
import com.example.wakelet.stubs.ResourceWrapperStub
import dtos.PhotographDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import kotlin.math.exp

class PhotographServiceTest {
    private lateinit var resourceWrapperStub: ResourceWrapperStub
    private lateinit var service: PhotographServiceImpl

    @Before
    fun setup() {
        resourceWrapperStub = ResourceWrapperStub()
        service = PhotographServiceImpl(resourceWrapperStub)
    }

    @Test
    fun `parses json to get correct number of photograph dtos`() {
        resourceWrapperStub.text = """
            [{
                "image": "https://images.unsplash.com/photo-1587315119275-80455dfc9d64?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd",
                "description": "green palm tree on green grass field during daytime",
                "name": "Taylor Simpson",
                "bio": "Travel Photographer\r\nwww.taylorgsimpson.com"
            }]
        """.trimIndent()

        val expected = PhotographDto(
            "https://images.unsplash.com/photo-1587315119275-80455dfc9d64?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjgwNDd",
            "green palm tree on green grass field during daytime",
            "Taylor Simpson",
            "Travel Photographer\r\nwww.taylorgsimpson.com")

        val photographDtos = service.getPhotographs().blockingGet()
        assertThat(photographDtos).isEqualTo(listOf(expected))
    }
}