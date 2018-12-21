package com.lakshmi.classregistration.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;


@Data
@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="classId",unique = true)
    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Courses courses;

    @Column (name ="title")
    private String title;

    @Column (name ="instructor")
    private  String instructor;

    @Column (name ="meetingTime")
    private Timestamp meetingTime;

    @Column (name ="meetingPlace")
    private  String meetingPlace;
}