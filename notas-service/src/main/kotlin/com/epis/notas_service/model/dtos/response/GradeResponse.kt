package com.epis.notas_service.model.dtos.response

data class GradeResponse(
    val id: Int,
    val grade: Int,
    val gradeType: String,
    val rating: Float
)
