package com.epis.notas_service.model.dtos.request

data class TeacherRequest(
    val name: String,
    val lastName: String,
    val email: String,
    val phone: String
)