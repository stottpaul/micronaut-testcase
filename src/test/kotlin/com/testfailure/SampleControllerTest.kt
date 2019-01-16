package com.testfailure

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.annotation.MicronautTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import javax.inject.Inject

@MicronautTest
class SampleControllerTest {

    @Inject
    @field:Client( "/")
    lateinit var client: RxHttpClient

    @Test
    fun `should return hello world`() {
        val response = client.toBlocking()
                .exchange("/test/hello?name=World", String::class.java)
        assertThat(response.body(), equalTo("Hello World"))
    }

    @Test
    fun `should return bad request when no name is passed`() {
        val exception = assertThrows<HttpClientResponseException> {
            client.toBlocking()
                    .exchange("/test/hello", String::class.java)
        }

        assertThat(exception.status, equalTo(HttpStatus.BAD_REQUEST))

        //I want to test the response body contains { "errorReason" : "Missing query parameter: name"}
    }

}

