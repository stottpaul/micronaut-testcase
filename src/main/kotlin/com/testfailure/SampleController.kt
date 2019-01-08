package com.testfailure

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/test")
class SampleController {

    @Get(uri = "/hello", processes = arrayOf(MediaType.TEXT_PLAIN))
    internal fun hello(): String {
        return "Hello World"
    }
}