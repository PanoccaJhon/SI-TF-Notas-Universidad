package com.epis.notas_service.controllers

import com.epis.notas_service.model.dtos.request.TeacherRequest
import com.epis.notas_service.model.dtos.response.TeacherResponse
import com.epis.notas_service.model.entities.Teacher
import com.epis.notas_service.services.TeacherService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teacher")
class TeacherController (
    private val teacherService: TeacherService
){

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeacher(@RequestBody teacherRequest: TeacherRequest): Teacher {
        return teacherService.createTeacher(teacherRequest)
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllTeachers(): List<TeacherResponse> {
        return teacherService.getAllTeachers()
    }

    // get teacher by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getTeacherById(@PathVariable id: Int): TeacherResponse {
        // service throws exception if teacher not found
        return teacherService.getTeacherById(id)
    }

}