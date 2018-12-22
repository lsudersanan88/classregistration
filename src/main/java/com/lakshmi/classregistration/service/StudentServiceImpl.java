package com.lakshmi.classregistration.service;

import com.lakshmi.classregistration.dto.StudentDto;
import com.lakshmi.classregistration.entity.StudentEntity;
import com.lakshmi.classregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  StudentRepository studentRepository;
  StudentEntity studentDto;

  @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto addStudent(StudentDto studentEntity) {
          studentDto  =  convertToDto(studentEntity);
          studentRepository.save(studentDto);
          studentEntity = dtoToModel(studentDto) ;
          return studentEntity;
    }

    public StudentEntity convertToDto(StudentDto student)
    {
        studentDto = new StudentEntity();
        studentDto.setEmail(student.getEmail());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setRedId(student.getRedId());
        studentDto.setPassword(student.getPassword());
        return studentDto;
    }

   public StudentDto dtoToModel(StudentEntity studentDto)
    {
        StudentDto studentEntity = new StudentDto();
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setRedId(studentDto.getRedId());
        return studentEntity;
    }
}
