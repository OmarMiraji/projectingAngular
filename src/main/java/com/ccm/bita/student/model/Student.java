package com.ccm.bita.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Tour")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String FirstName;
    @Column(nullable=false)
    private String SecondName;
    @Column(nullable=false)
    private String ThirdName;
    @Column(nullable=false)
    private String TellNumber;
    @Column(nullable=false)
    private String VisitName;
    @Column(nullable=false)
    private String Age;


public Long getId() {
    return id;
}


public void setId(Long id) {
    this.id = id;
}


public String getFirstName() {
    return FirstName;
}


public void setFirstName(String firstName) {
    FirstName = firstName;
}


public String getSecondName() {
    return SecondName;
}


public void setSecondName(String secondName) {
    SecondName = secondName;
}


public String getThirdName() {
    return ThirdName;
}


public void setThirdName(String thirdName) {
    ThirdName = thirdName;
}


public String getTellNumber() {
    return TellNumber;
}


public void setTellNumber(String tellNumber) {
    TellNumber = tellNumber;
}


public String getVisitName() {
    return VisitName;
}


public void setVisitName(String visitName) {
    VisitName = visitName;
}


public String getAge() {
    return Age;
}


public void setAge(String age) {
    Age = age;
}




}