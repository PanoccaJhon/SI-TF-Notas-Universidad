package com.epis.notas_service.repositories

import com.epis.notas_service.model.entities.CourseGrades
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseGradesRepository: JpaRepository<CourseGrades, Int> {
    fun findByStudentCourseId(studentCourseId: Int): MutableList<CourseGrades>
}