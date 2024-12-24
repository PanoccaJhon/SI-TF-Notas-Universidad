package com.epis.notas_service.model.dtos.response

data class CourseGradesResponse(
    val id: Int,
    val courseId: Int,
    val studentId: Int,
    val grades: List<GradeResponse>,
    val average: Float?,
    val finalGrade: Float?,
    val limitGrade: Int
)
