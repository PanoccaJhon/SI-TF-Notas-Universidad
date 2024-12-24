package com.epis.notas_service.services

import com.epis.notas_service.model.dtos.request.CourseRequest
import com.epis.notas_service.model.dtos.response.CourseResponse
import com.epis.notas_service.model.dtos.response.StudentResponse
import com.epis.notas_service.model.entities.Course
import com.epis.notas_service.model.entities.StudentCourse
import com.epis.notas_service.repositories.CourseRepository
import com.epis.notas_service.repositories.StudentCourseRepository
import com.epis.notas_service.repositories.StudentRepository
import com.epis.notas_service.repositories.TeacherRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val courseRepository: CourseRepository,
    private val teacherRepository: TeacherRepository,
    private val studentRepository: StudentRepository,
    private val studentService: StudentService,
    private val studentCourseRepository: StudentCourseRepository
) {



    // create a course
    fun createCourse(courseRequest: CourseRequest): Course {
        val course = Course(
            name = courseRequest.name,
            code = courseRequest.code,
            description = courseRequest.description,
            credits = courseRequest.credits,
            teacherId = courseRequest.teacherId,
        )
        val courseSaved : Course
        try {
            courseSaved = courseRepository.save(course)
        } catch (e: Exception) {
            throw Exception("Error creating course")
        }
        return courseSaved
    }


    // add student to course
    fun addStudentToCourse(courseId: Int, studentId: Int) {
        val course = courseRepository.findById(courseId).orElseThrow {
            throw Exception("Course not found")
        }
        val student = studentRepository.findById(studentId).orElseThrow {
            throw Exception("Student not found")
        }
        val relation = StudentCourse(
            courseId = courseId,
            studentId = studentId
        )
        // Create CourseGrades for relation

        studentCourseRepository.save(relation)
    }

    // delete student from course
    fun deleteStudentFromCourse(courseId: Int, studentId: Int) {
        val relation = studentCourseRepository.findByStudentIdAndCourseId(courseId, studentId)
        studentCourseRepository.delete(relation)
    }

    // delete course by id
    fun deleteCourseById(id: Int) {
        courseRepository.deleteById(id)
    }


    // get course by id
    fun getCourseById(id: Int): CourseResponse {
        val course = courseRepository.findById(id).orElseThrow {
            throw Exception("Course not found")
        }
        return mapCourseToCourseResponse(course)
    }


    // get all courses
    fun getAllCourses(): List<CourseResponse> {
        val courses = courseRepository.findAll()
        return courses.map { mapCourseToCourseResponse(it) }
    }

    fun mapCourseToCourseResponse(course: Course): CourseResponse {
        return CourseResponse(
            id = course.id,
            name = course.name,
            code = course.code,
            description = course.description,
            credits = course.credits,
            teacherId = course.teacherId,
        )
    }



}