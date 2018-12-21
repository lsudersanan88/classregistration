package com.lakshmi.classregistration.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Courses {

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="courseId",unique = true)
    private Integer courseId;

    @ManyToOne
    @JoinColumn(name = "majorId", referencedColumnName = "majorId")
    private Majors majors;

    @Column (name ="level",unique = true)
    private String level;
    @Column (name ="time")
    private  String time;
}


