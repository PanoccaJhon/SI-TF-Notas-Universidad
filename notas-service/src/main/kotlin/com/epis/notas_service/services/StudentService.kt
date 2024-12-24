package com.epis.notas_service.services

import com.epis.notas_service.model.dtos.request.StudentRequest
import com.epis.notas_service.model.dtos.response.StudentResponse
import com.epis.notas_service.model.entities.Student
import com.epis.notas_service.repositories.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService (
    private val studentRepository: StudentRepository
){
    fun createStudent(studentRequest: StudentRequest): Student {
        val student = Student(
            name = studentRequest.name,
            lastName = studentRequest.lastName,
            email = studentRequest.email,
            phone = studentRequest.phone,
            cui = studentRequest.cui
        )
        return studentRepository.save(student)

    }

    fun getStudentById(id: Int): StudentResponse {
        val student = studentRepository.findById(id).orElseThrow { throw Exception("Student not found") }
        return mapStudentToStudentResponse(student)
    }

    fun getAllStudents(): List<StudentResponse> {
        val students = studentRepository.findAll()
        return students.map { mapStudentToStudentResponse(it) }
    }

    fun mapStudentToStudentResponse(student: Student): StudentResponse {
        return StudentResponse(
            id = student.id,
            name = student.name,
            lastName = student.lastName,
            email = student.email,
            phone = student.phone,
            cui = student.cui
        )
    }
}