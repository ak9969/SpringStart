package com.akshat.springstart.model;

import javax.persistence.*;

@Entity
@Table(name="exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String marks;




    public Exam() {
    }

    public Exam(String courseName, String marks) {
        this.courseName = courseName;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Test{" +
                "courseName='" + courseName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
