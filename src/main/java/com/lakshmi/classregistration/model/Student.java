package com.lakshmi.classregistration.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Student {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name ="studentId",unique = true)
    private Integer studentId;
    @Column (name ="redId",unique = true)
    private Integer redId;
    @Column (name ="firstName")
    private  String firstName;
    @Column (name ="lastName")
    private String lastName;
    @Column (name ="email",unique = true)
    private String email;


}
