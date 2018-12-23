package com.lakshmi.classregistration.dto;


import java.sql.Timestamp;

public class ClassesEntityDto {

    private Integer classId;
    private CoursesDto courses;
    private String title;
    private  String instructor;
    private Timestamp meetingTime;
    private  String meetingPlace;
}