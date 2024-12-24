package com.epis.notas_service.repositories

import com.epis.notas_service.model.entities.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: JpaRepository<Course, Int> {
}