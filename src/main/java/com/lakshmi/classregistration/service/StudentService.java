package com.lakshmi.classregistration.service;

import com.lakshmi.classregistration.dto.StudentDto;

import java.util.List;

public interface StudentService {

     StudentDto addStudent(StudentDto studentDto);
     List<StudentDto> getAllStudents();
     StudentDto getStudentById(Integer studentId);
     void deleteStudentById(Integer studentId);
     StudentDto updateStudent(StudentDto studentDto,Integer studentId );
     StudentDto editStudent(StudentDto studentDto,Integer studentId );
}
