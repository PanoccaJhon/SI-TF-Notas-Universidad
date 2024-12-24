package com.epis.notas_service.repositories

import com.epis.notas_service.model.entities.StudentCourse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentCourseRepository: JpaRepository<StudentCourse, Int> {
    // find student-course by student id and course id
    fun findByStudentIdAndCourseId(studentId: Int, courseId: Int): StudentCourse

}