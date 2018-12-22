package com.lakshmi.classregistration.service;

import com.lakshmi.classregistration.dto.StudentDto;
import com.lakshmi.classregistration.entity.StudentEntity;
import com.lakshmi.classregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
          StudentEntity  studentEntity  =  convertDtoToEntity(studentDto);
          studentRepository.save(studentEntity);
          studentDto = convertEntityToDto(studentEntity) ;
          return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtos = new ArrayList<>() ;
        List<StudentEntity> studentEntities =  studentRepository.findAll();
        for (StudentEntity studentEntity:studentEntities)
        {
          StudentDto  studentDto = convertEntityToDto(studentEntity) ;
          studentDtos.add(studentDto);
        }
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Integer studentId) {
        List<StudentDto> allStudents = getAllStudents();
        for (StudentDto student:allStudents) {
            if(studentId.equals(student.getStudentId()))
            {
             return student;
            }
        }

        return null;
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        StudentDto studentDto = getStudentById(studentId);

            if(studentDto!= null)
            {
               studentRepository.deleteById(studentId);
            }
        }



    public StudentEntity convertDtoToEntity(StudentDto studentDto)
    {
        StudentEntity studentEntity = new StudentEntity();
        if(studentDto.getStudentId() != null){
            studentEntity.setStudentId(studentDto.getStudentId());
        }

        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setPassword(studentDto.getPassword());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setRedId(studentDto.getRedId());

        return studentEntity;
    }


    public StudentDto convertEntityToDto(StudentEntity studentEntity)
    {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(studentEntity.getStudentId());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setRedId(studentEntity.getRedId());
        studentDto.setPassword(studentEntity.getPassword());
        return studentDto;
    }


}
