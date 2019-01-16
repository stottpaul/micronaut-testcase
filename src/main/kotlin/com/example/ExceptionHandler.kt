package com.example

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import javax.inject.Singleton

@Produces
@Singleton
@Requires(classes = [Exception::class, ExceptionHandler::class])
class GlobalExceptionHandler : ExceptionHandler<Exception, HttpResponse<Any>> {

    override fun handle(request: HttpRequest<Any>, exception: Exception): HttpResponse<Any> {
        return when (exception) {
            is BadRequestException -> HttpResponse.badRequest(mapOf("errorReason" to exception.message))
            else -> HttpResponse.serverError()
        }
    }
}
