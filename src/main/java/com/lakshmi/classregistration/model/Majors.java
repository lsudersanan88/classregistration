package com.lakshmi.classregistration.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Majors {

 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="majorId",unique = true)
    private Integer majorId;
    @Column (name ="majorName",unique = true)
    private String majorName;
    @Column (name ="college")
    private  String college;

}
