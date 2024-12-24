package com.epis.notas_service.controllers

import com.epis.notas_service.model.dtos.request.StudentRequest
import com.epis.notas_service.model.dtos.response.StudentResponse
import com.epis.notas_service.model.entities.Student
import com.epis.notas_service.services.StudentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController (
    private val studentService: StudentService
) {

    // add a student
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createStudent(@RequestBody studentRequest: StudentRequest): Student {
        // service throws exception if student not found
        return studentService.createStudent(studentRequest)
    }

    // get all students
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllStudents(): List<StudentResponse> {
        return studentService.getAllStudents()
    }

    // get student by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getStudentById(@PathVariable id: Int): StudentResponse {
        // service throws exception if student not found
        return studentService.getStudentById(id)
    }
}