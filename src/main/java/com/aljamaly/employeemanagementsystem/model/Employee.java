package com.aljamaly.employeemanagementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Employee implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private String jobTitle;
    private String imageURL;
    @Column (nullable = false, updatable = false)
    private String empCode;

    public Employee(String name, String email, String phoneNum,
                    String jobTitle, String imageURL, String empCode) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.jobTitle = jobTitle;
        this.imageURL = imageURL;
        this.empCode = empCode;
    }
}
