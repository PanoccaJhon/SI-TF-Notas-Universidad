package com.epis.notas_service.services

import com.epis.notas_service.model.dtos.request.TeacherRequest
import com.epis.notas_service.model.dtos.response.TeacherResponse
import com.epis.notas_service.model.entities.Teacher
import com.epis.notas_service.repositories.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherService(
    private val teacherRepository: TeacherRepository
){
    fun createTeacher(teacherRequest: TeacherRequest): Teacher {
        val teacher = Teacher(
            name = teacherRequest.name,
            lastName = teacherRequest.lastName,
            email = teacherRequest.email,
            phone = teacherRequest.phone
        )
        return teacherRepository.save(teacher)
    }

    fun getAllTeachers(): List<TeacherResponse> {
        val teachers = teacherRepository.findAll()
        return teachers.map { mapTeacherToTeacherResponse(it) }
    }

    fun getTeacherById(id: Int): TeacherResponse {
        val teacher = teacherRepository.findById(id).orElseThrow { throw Exception("Teacher not found") }
        return mapTeacherToTeacherResponse(teacher)
    }

    fun mapTeacherToTeacherResponse(teacher: Teacher): TeacherResponse {
        return TeacherResponse(
            id = teacher.id,
            name = teacher.name,
            lastName = teacher.lastName,
            email = teacher.email,
            phone = teacher.phone
        )
    }
}