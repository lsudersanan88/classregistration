package com.lakshmi.classregistration.dto;

import lombok.Data;

@Data
public class AddStudentDto {

    private Integer addStudentId;
    private CoursesDto courses;
    private MajorsDto majors;
/*
    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "classId", insert="false", update="false")
    private ClassesEntityDto classes;*/
    private StudentDto student;


}