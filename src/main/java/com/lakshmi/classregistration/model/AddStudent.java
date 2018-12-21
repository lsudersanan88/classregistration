package com.lakshmi.classregistration.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class AddStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="classId",unique = true)
    private Integer addStudentId;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "majorId", referencedColumnName = "majorId")
    private Majors majors;
/*
    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "classId", insert="false", update="false")
    private Classes classes;*/

    @ManyToOne
    @JoinColumn(name = "redId", referencedColumnName = "redId")
    private Student student;


}