package com.epis.notas_service.model.dtos.response

data class StudentResponse(
    val id: Int,
    val name: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val cui: String
)
