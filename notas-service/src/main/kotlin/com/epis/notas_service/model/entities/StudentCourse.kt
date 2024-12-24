package com.epis.notas_service.model.entities

import jakarta.persistence.*

@Entity
@Table(name = "student_courses")
data class StudentCourse(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "student_id", nullable = false)
    val studentId: Int,
    @Column(name = "course_id", nullable = false)
    val courseId: Int
)
