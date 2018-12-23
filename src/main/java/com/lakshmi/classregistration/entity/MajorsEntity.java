package com.lakshmi.classregistration.entity;

import javax.persistence.*;

@Entity
public class MajorsEntity {

 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="majorId",unique = true)
    private Integer majorId;
    @Column (name ="majorName",unique = true)
    private String majorName;
    @Column (name ="college")
    private  String college;

}
