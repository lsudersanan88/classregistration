package com.lakshmi.classregistration.controller;

import com.lakshmi.classregistration.dto.StudentDto;
import com.lakshmi.classregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/registration")
public class StudentController {

    @Autowired
    StudentService studentService;

    // api doc
    @PostMapping("/addstudent")
    public ResponseEntity addStudent(@RequestBody StudentDto studentDto)

    {
        StudentDto studentInserted = studentService.addStudent(studentDto);
        if(studentDto!= null)
        {
            return new ResponseEntity(studentInserted, HttpStatus.CREATED);
        }

        return new ResponseEntity("not inserted", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getstudents")
    public ResponseEntity<List> getStudents()

    {
        List<StudentDto> students = studentService.getAllStudents();
        if(students.size()!=0)
        {
            return new ResponseEntity(students, HttpStatus.OK);
        }

        return new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
    }


    @GetMapping("/getstudentbyid/{studentId}")
    public ResponseEntity<List> getStudentById(@PathVariable("studentId") Integer studentId)

    {
        StudentDto studentDto = studentService.getStudentById(studentId);
        if(studentDto!= null)
        {
            return new ResponseEntity(studentDto, HttpStatus.OK);
        }

        return new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deletestudentbyid/{studentId}")
    public ResponseEntity deleteStudentById(@PathVariable(value = "studentId", required = true) Integer studentId)
    {
        if( studentService.getStudentById(studentId)!= null )
        {
            studentService.deleteStudentById(studentId);
            return new ResponseEntity( HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updatestudent/{studentId}")
    public ResponseEntity updateStudent(@RequestBody StudentDto studentDto,
                                        @PathVariable("studentId") Integer studentId)

    {
        if( studentService.getStudentById(studentId)!= null )
        {
            StudentDto updatedStudent =   studentService.updateStudent(studentDto,studentId);
            return new ResponseEntity(updatedStudent, HttpStatus.CREATED);
        }

        return new ResponseEntity("not found", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/editstudent/{studentId}")
    public ResponseEntity editStudent(@RequestBody StudentDto studentDto,
                                        @PathVariable("studentId") Integer studentId)

    {
        if( studentService.getStudentById(studentId)!= null )
        {
            StudentDto updatedStudent =   studentService.editStudent(studentDto,studentId);
            return new ResponseEntity(updatedStudent, HttpStatus.CREATED);
        }

        return new ResponseEntity("not found", HttpStatus.NOT_FOUND);
    }

}
