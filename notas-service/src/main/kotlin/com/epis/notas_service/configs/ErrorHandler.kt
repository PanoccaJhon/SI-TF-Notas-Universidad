package com.epis.notas_service.configs

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component


@Component
class ErrorHandler: AuthenticationEntryPoint {
    private val logger: Logger = LoggerFactory.getLogger(ErrorHandler::class.java)

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        e: AuthenticationException
    ) {
        logger.error("Unauthorized error. Message - {}", e.message)
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized")
    }

}