package com.lakshmi.classregistration.entity;

import javax.persistence.*;


@Entity
public class AddStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="classId",unique = true)
    private Integer addStudentId;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private CoursesEntity courses;

    @ManyToOne
    @JoinColumn(name = "majorId", referencedColumnName = "majorId")
    private MajorsEntity majors;
/*
    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "classId", insert="false", update="false")
    private ClassesEntityDto classes;*/

    @ManyToOne
    @JoinColumn(name = "redId", referencedColumnName = "redId")
    private StudentEntity student;


}