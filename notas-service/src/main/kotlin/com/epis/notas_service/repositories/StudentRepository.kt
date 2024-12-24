package com.epis.notas_service.repositories

import com.epis.notas_service.model.entities.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Int> {
}