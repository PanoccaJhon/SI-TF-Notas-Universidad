package com.epis.notas_service.controllers

import com.epis.notas_service.model.dtos.GradeCreateRequest
import com.epis.notas_service.model.dtos.GradeUpdateRequest
import com.epis.notas_service.services.GradesService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
@RequestMapping("/grades")
class GradesController (
    private val gradesService: GradesService
) {

    // Crear las notas para el estudiante del curso
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createGradesForStudentCourse(@RequestBody gradesRequest: GradeCreateRequest) {
        val state = gradesService.createGrade(gradesRequest)
    }

    // Actualizar las notas para el estudiante del curso
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    fun updateGradesForStudentCourse(@RequestBody gradesRequest: GradeUpdateRequest) {
        val state = gradesService.updateGradePartial(gradesRequest)
    }



}