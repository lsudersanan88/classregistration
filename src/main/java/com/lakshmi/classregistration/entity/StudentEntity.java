package com.lakshmi.classregistration.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class StudentEntity
{
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
    @Column (name ="password",unique = true)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getRedId() {
        return redId;
    }

    public void setRedId(Integer redId) {
        this.redId = redId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}