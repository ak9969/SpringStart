package com.akshat.springstart.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;

    @OneToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Set<Exam> exams = new HashSet<>();

    public Student() {
    }

    public Student( String name, Integer age) {
        this.name = name;
        this.age = age;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Exam> getTests() {
        return exams;
    }

    public void setTests(Set<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tests=" + exams +
                '}';
    }
}
