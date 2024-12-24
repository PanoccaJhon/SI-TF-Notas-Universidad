package com.epis.notas_service.model.entities

import jakarta.persistence.*

@Entity
@Table(name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "last_name", nullable = false)
    val lastName: String,
    @Column(name = "email", nullable = false)
    val email: String,
    @Column(name = "phone", nullable = true)
    val phone: String,
    @Column(name = "cui", nullable = false)
    val cui: String,
)