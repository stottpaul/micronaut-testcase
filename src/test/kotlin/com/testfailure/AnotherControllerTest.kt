package com.testfailure

import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertTrue
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class AnotherControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Inject
    lateinit var service: Service

    @Test
    fun `should return hello world`() {
//        `when`(service.getMessage()).thenReturn("Something else")
        every { service.getMessage() }.returns("Something else")
        val response: String = client.toBlocking().retrieve("/test/hello")
        assertTrue(response == "Something else")
    }

    @MockBean(SampleService::class)
    fun mockService(): Service = mockk()
}

