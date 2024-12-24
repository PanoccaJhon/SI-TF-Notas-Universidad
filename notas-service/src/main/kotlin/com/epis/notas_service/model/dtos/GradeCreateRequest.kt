package com.epis.notas_service.model.dtos

data class GradeCreateRequest(
    val gradeStudentId: Int,
    val limitGrade:Int,
    val ratings: List<Float>
)
