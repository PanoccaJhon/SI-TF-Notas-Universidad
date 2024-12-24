package com.epis.notas_service.model.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "teachers")
data class Teacher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "last_name", nullable = false)
    val lastName: String,
    @Column(name = "email", nullable = false)
    val email: String,
    @Column(name = "phone", nullable = false)
    val phone: String,
)
