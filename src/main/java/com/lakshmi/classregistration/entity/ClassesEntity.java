package com.lakshmi.classregistration.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ClassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="classId",unique = true)
    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private CoursesEntity courses;

    @Column (name ="title")
    private String title;

    @Column (name ="instructor")
    private  String instructor;

    @Column (name ="meetingTime")
    private Timestamp meetingTime;

    @Column (name ="meetingPlace")
    private  String meetingPlace;
}