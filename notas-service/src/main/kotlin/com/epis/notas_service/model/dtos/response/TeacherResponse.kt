package com.epis.notas_service.model.dtos.response

data class TeacherResponse(
    val id: Int,
    val name: String,
    val lastName: String,
    val email: String,
    val phone: String
)