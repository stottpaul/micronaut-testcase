package com.testfailure

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Singleton

@Controller("/test")
class SampleController(private val service: Service)  {
    @Get(uri = "/hello", processes = arrayOf(MediaType.TEXT_PLAIN))
    fun hello(): String {
        return service.getMessage()
    }
}

interface Service {
    fun getMessage(): String
}

@Singleton
class SampleService : Service {
    override fun getMessage() = "Hello World"

}