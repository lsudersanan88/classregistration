package com.lakshmi.classregistration.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ClassesEntityDto {

    private Integer classId;
    private CoursesDto courses;
    private String title;
    private  String instructor;
    private Timestamp meetingTime;
    private  String meetingPlace;
}