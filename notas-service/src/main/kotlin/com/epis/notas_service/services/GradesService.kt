package com.epis.notas_service.services

import com.epis.notas_service.model.dtos.GradeCreateRequest
import com.epis.notas_service.model.dtos.GradeUpdateRequest
import com.epis.notas_service.model.dtos.GradesResponse
import com.epis.notas_service.model.entities.CourseGrades
import com.epis.notas_service.model.entities.Grade
import com.epis.notas_service.repositories.CourseGradesRepository
import com.epis.notas_service.repositories.GradeRepository
import com.epis.notas_service.repositories.StudentCourseRepository
import org.springframework.stereotype.Service

@Service
class GradesService(
    private val gradeRepository: GradeRepository,
    private val courseGradesRepository: CourseGradesRepository,
    private val studentCourseRepository: StudentCourseRepository,
) {
    // optener todas las notas del estudiante
    fun getAllGradesByStudentCourseId(studentCourseId: Int): GradesResponse {
        val courseGrade = courseGradesRepository.findByStudentCourseId(studentCourseId)
        val grades = gradeRepository.findAllByCourseGradesId(courseGrade.first().id)
        val outgrades = GradesResponse(0,0,0,0,0,0)
        if (grades.isEmpty()) {
            throw Exception("Grades not found")
        }else {

            grades.forEach { grade: Grade ->
                if( grade.partial == 1 && grade.gradeType == "C"){
                    outgrades.continua1 = grade.grade?.toInt() ?: 0
                }else if (grade.partial == 1 && grade.gradeType == "P"){
                    outgrades.partial1 = grade.grade?.toInt() ?: 0
                }else if (grade.partial == 2 && grade.gradeType == "C"){
                    outgrades.continua2 = grade.grade?.toInt() ?: 0
                }else if (grade.partial == 2 && grade.gradeType == "P"){
                    outgrades.partial2 = grade.grade?.toInt() ?: 0
                }else if (grade.partial == 3 && grade.gradeType == "C"){
                    outgrades.continua3 = grade.grade?.toInt() ?: 0
                }else if (grade.partial == 3 && grade.gradeType == "P") {
                    outgrades.partial3 = grade.grade?.toInt() ?: 0
                }
            }
        }
        return outgrades
    }

    // create Grade por Course
    fun createGrade(gradesRequest: GradeCreateRequest) : Boolean {
        val courseStudentId = gradesRequest.gradeStudentId
        val limitGrade = gradesRequest.limitGrade
        val ratings = gradesRequest.ratings
        val relationCourse = studentCourseRepository.findById(courseStudentId).orElseThrow {
            throw Exception("Course not found")
        }
        val relationGrade = CourseGrades(
            studentCourseId = relationCourse.id,
            limitGrade = limitGrade,
            finalGrade = 0f,
            average = 0f,
        )
        courseGradesRepository.save(relationGrade)

        val c1 = Grade(
            gradeType = "C",
            partial = 1,
            grade = 0,
            courseGradesId = relationGrade.id,
            rating = ratings[0],
        )
        gradeRepository.save(c1)
        val c2 = Grade(
            gradeType = "C",
            partial = 2,
            grade = 0,
            courseGradesId = relationGrade.id,
            rating = ratings[1],
        )
        gradeRepository.save(c2)
        val c3 = Grade(
            gradeType = "C",
            partial = 3,
            grade = 0,
            courseGradesId = relationGrade.id,
            rating = ratings[2],
        )
        gradeRepository.save(c3)
        val p1 = Grade(
            gradeType = "P",
            partial = 1,
            grade = 0,
            courseGradesId = relationGrade.id,
            rating = ratings[3],
        )
        gradeRepository.save(p1)
        val p2 = Grade(
            gradeType = "P",
            partial = 2,
            grade = 0,
            courseGradesId = relationGrade.id,
            rating = ratings[4],
        )
        gradeRepository.save(p2)
        val p3 = Grade(
            gradeType = "P",
            partial = 3,
            grade = 0,
            courseGradesId = relationGrade.id,
            rating = ratings[5],
        )
        gradeRepository.save(p3)
        return true
    }

    // update Grade
    fun updateGradePartial(gradesRequest: GradeUpdateRequest){
        val courseStudentId: Int = gradesRequest.courseStudentId
        val partial: Int = gradesRequest.partial
        val gradeC: Int = gradesRequest.gradeC
        val gradeP: Int = gradesRequest.gradeP

        val relationCourse = studentCourseRepository.findById(courseStudentId).orElseThrow {
            throw Exception("Course not found")
        }
        val relationGrade = courseGradesRepository.findByStudentCourseId(relationCourse.id)

        val grades = gradeRepository.findByCourseGradesIdAndPartial(relationGrade.first().id, partial)
        val c = grades.first { it.gradeType == "C" }
        val p = grades.first { it.gradeType == "P" }

        c.grade = gradeC
        p.grade = gradeP

        gradeRepository.save(c)
        gradeRepository.save(p)
    }


}