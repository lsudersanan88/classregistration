package com.lakshmi.classregistration.util;

import com.lakshmi.classregistration.dto.StudentDto;
import com.lakshmi.classregistration.entity.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentUtil {

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
