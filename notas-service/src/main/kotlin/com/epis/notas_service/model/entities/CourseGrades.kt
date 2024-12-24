package com.epis.notas_service.model.entities

import jakarta.persistence.*

@Entity
@Table(name = "course_grades")
data class CourseGrades(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "average", nullable = true)
    val average: Float?,

    @Column(name = "final_grade", nullable = true)
    val finalGrade: Float?,

    @Column(name = "limit_grade", nullable = false)
    val limitGrade: Int,

    @Column(name = "student_course_id", nullable = false)
    val studentCourseId: Int
)
