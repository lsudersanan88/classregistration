package com.lakshmi.classregistration.dto;

import lombok.Data;


@Data
public class CoursesDto {
    private Integer courseId;
    private MajorsDto majors;
    private String level;
    private  String time;
}


