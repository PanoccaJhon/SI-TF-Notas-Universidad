package com.epis.notas_service.model.dtos.request

data class CourseRequest(
    val code: String,
    val name: String,
    val description: String,
    val credits: Int,
    val teacherId: Int,
)
