package com.epis.notas_service.model.dtos.request

data class CourseGradesRequest(
    val courseId: Int,
    val studentId: Int,
    val grades: List<GradeRequest>?,
    val average: Float?,
    val finalGrade: Float?,
    val limitGrade: Int,
)
