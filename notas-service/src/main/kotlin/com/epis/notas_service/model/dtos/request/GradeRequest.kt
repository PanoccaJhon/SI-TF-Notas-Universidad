package com.epis.notas_service.model.dtos.request

data class GradeRequest(
    val grade: Int,
    val gradeType: String,
    val rating: Float
)
