package com.epis.notas_service.model.dtos

data class GradeUpdateRequest(
    val courseStudentId: Int,
    val partial: Int,
    val gradeC: Int,
    val gradeP: Int
)
