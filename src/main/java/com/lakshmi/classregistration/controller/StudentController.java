package com.lakshmi.classregistration.controller;

import com.lakshmi.classregistration.dto.StudentDto;
import com.lakshmi.classregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity addStudent( StudentDto studentEntity)

    {
           studentService.addStudent(studentEntity);
        if(studentEntity!= null)
        {
            return new ResponseEntity( HttpStatus.OK);
        }

        return null;
    }
}
