package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Singleton

@Controller("/test")
class SampleController(private val service: Service) {
    @Get("/hello{?name}")
    fun hello(name: String?): String {
        return if (name == null) {
            throw BadRequestException("Missing query parameter: name")
        } else {
            service.getMessage(name)
        }
    }

}

class BadRequestException(message: String) : Exception(message)

interface Service {
    fun getMessage(name: String?): String
}

@Singleton
class SampleService : Service {
    override fun getMessage(name: String?): String {
        return "Hello $name"
    }

}