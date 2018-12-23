package com.lakshmi.classregistration.entity;


import javax.persistence.*;

@Entity
public class CoursesEntity {

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="courseId",unique = true)
    private Integer courseId;

    @ManyToOne
    @JoinColumn(name = "majorId", referencedColumnName = "majorId")
    private MajorsEntity majors;

    @Column (name ="level",unique = true)
    private String level;
    @Column (name ="time")
    private  String time;
}


