package com.epis.notas_service.model.dtos.response

data class CourseResponse(
    val id: Int,
    val name: String,
    val description: String,
    val credits: Int,
    val code: String,
    val teacherId: Int,
)
