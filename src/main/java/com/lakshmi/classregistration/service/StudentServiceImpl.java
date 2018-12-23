package com.lakshmi.classregistration.service;

import com.lakshmi.classregistration.dto.StudentDto;
import com.lakshmi.classregistration.entity.StudentEntity;
import com.lakshmi.classregistration.repository.StudentRepository;
import com.lakshmi.classregistration.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  StudentRepository studentRepository;
  @Autowired
  StudentUtil studentUtil;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
          StudentEntity  studentEntity  = studentUtil.convertDtoToEntity(studentDto);
          studentRepository.save(studentEntity);
          studentDto = studentUtil.convertEntityToDto(studentEntity) ;
          return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtos = new ArrayList<>() ;
        List<StudentEntity> studentEntities =  studentRepository.findAll();
        for (StudentEntity studentEntity:studentEntities)
        {
          StudentDto  studentDto = studentUtil.convertEntityToDto(studentEntity) ;
          studentDtos.add(studentDto);
        }
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Integer studentId) {
           Optional<StudentEntity> mayBeStudentEntity =  studentRepository.findById(studentId);
           if(mayBeStudentEntity.isPresent())
           {
               StudentDto  studentDto = studentUtil.convertEntityToDto(mayBeStudentEntity.get()) ;
               return studentDto;
           }
        return null;
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
        }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Integer studentId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        studentEntity.get().setEmail(studentDto.getEmail());
        studentEntity.get().setFirstName(studentDto.getFirstName());
        studentEntity.get().setLastName(studentDto.getLastName());
        studentEntity.get().setPassword(studentDto.getPassword());
        studentEntity.get().setRedId(studentDto.getRedId());
        studentRepository.save(studentEntity.get());
        studentDto = studentUtil.convertEntityToDto(studentEntity.get()) ;
        return studentDto;
    }

    @Override
    public StudentDto editStudent(StudentDto studentDto, Integer studentId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        if(studentDto.getEmail()!= null) {
            studentEntity.get().setEmail(studentDto.getEmail());
        }
        if(studentDto.getFirstName()!= null) {
            studentEntity.get().setFirstName(studentDto.getFirstName());
        }
        if(studentDto.getLastName()!= null) {
            studentEntity.get().setLastName(studentDto.getLastName());
        }
        if(studentDto.getPassword()!= null) {
            studentEntity.get().setPassword(studentDto.getPassword());
        }
        if(studentDto.getRedId()!= null) {
            studentEntity.get().setRedId(studentDto.getRedId());
        }
        studentRepository.save(studentEntity.get());
        studentDto = studentUtil.convertEntityToDto(studentEntity.get()) ;
        return studentDto;
    }


}
