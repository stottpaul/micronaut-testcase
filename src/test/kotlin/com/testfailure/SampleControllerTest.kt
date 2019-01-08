package com.testfailure

import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import junit.framework.Assert.assertTrue
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class SampleControllerTest {

    @Inject
    @Client( "/")
    lateinit var client: RxHttpClient

    @Test
    fun `should return hello world`() {
        val response: String = client.toBlocking().retrieve("/test/hello")
        assertTrue(response.equals("Hello World"))
    }
}