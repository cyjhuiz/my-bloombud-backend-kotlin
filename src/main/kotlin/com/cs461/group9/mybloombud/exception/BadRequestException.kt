package com.cs461.group9.mybloombud.exception

import org.springframework.http.HttpStatus
import java.time.ZoneId
import java.time.ZonedDateTime

class BadRequestException(
    override val message: String? = null,
): RuntimeException() {
    private val httpStatus = HttpStatus.BAD_REQUEST

    private val timestamp = ZonedDateTime.now(ZoneId.of("Z"))
}