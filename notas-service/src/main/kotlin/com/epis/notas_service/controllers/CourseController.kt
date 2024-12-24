package com.epis.notas_service.controllers

import com.epis.notas_service.model.dtos.StudentIdRequest
import com.epis.notas_service.model.dtos.request.CourseRequest
import com.epis.notas_service.model.dtos.response.CourseResponse
import com.epis.notas_service.model.dtos.response.StudentResponse
import com.epis.notas_service.model.entities.Course
import com.epis.notas_service.services.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/course")
class CourseController (
    private val courseService: CourseService
){

    // add a course
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCourse(@RequestBody courseRequest: CourseRequest): Course {
        // service throws exception if course not found
        return courseService.createCourse(courseRequest)
    }

    // get all courses
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllCourses(): List<CourseResponse> {
        return courseService.getAllCourses()
    }

    // get course by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCourseById(@PathVariable id: Int): CourseResponse {
        // service throws exception if course not found
        return courseService.getCourseById(id)
    }



}