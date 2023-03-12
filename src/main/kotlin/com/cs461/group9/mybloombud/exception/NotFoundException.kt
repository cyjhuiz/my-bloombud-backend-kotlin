package com.cs461.group9.mybloombud.exception

import org.springframework.http.HttpStatus
import java.time.ZoneId
import java.time.ZonedDateTime

class NotFoundException(
    override val message: String? = null,
): RuntimeException() {
    private val httpStatus = HttpStatus.NOT_FOUND

    private val timestamp = ZonedDateTime.now(ZoneId.of("Z"))
}