package com.epis.notas_service.model.entities

import jakarta.persistence.*

@Entity
@Table(name = "grades")
data class Grade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "grade", nullable = true)
    var grade: Int?,
    @Column(name = "grade_type", nullable = false)
    val gradeType: String,
    @Column(name = "partial", nullable = true)
    val partial: Int,
    @Column(name = "rating", nullable = true)
    val rating: Float?,
    @Column(name = "course_grades_id", nullable = false)
    val courseGradesId: Int
)
