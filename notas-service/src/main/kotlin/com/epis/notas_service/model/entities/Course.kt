package com.epis.notas_service.model.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "code", nullable = false)
    val code: String,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "description", nullable = false)
    val description: String,
    @Column(name = "credits", nullable = false)
    val credits: Int,
    @Column(name = "teacher_id", nullable = false)
    val teacherId: Int,
)
