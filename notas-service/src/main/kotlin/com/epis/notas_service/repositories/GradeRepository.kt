package com.epis.notas_service.repositories

import com.epis.notas_service.model.entities.Grade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GradeRepository: JpaRepository<Grade, Int> {
    fun findByCourseGradesIdAndPartial(courseGradesId: Int, partial: Int): MutableList<Grade>
    fun findAllByCourseGradesId(courseGradesId: Int): MutableList<Grade>
}