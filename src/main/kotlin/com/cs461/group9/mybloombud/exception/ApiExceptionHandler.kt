package com.cs461.group9.mybloombud.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(value = [BadRequestException::class])
    fun handleApiBadRequestException(badRequestException: BadRequestException?): ResponseEntity<Any?>? {
        return ResponseEntity(badRequestException, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [GenericRequestException::class])
    fun handleApiGenericRequestException(genericRequestException: GenericRequestException?): ResponseEntity<Any?>? {
        return ResponseEntity(genericRequestException, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}