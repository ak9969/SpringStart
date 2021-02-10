package com.akshat.springstart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.akshat.springstart.Dao.StudentRepo;
import com.akshat.springstart.model.Exam;
import com.akshat.springstart.model.Student;

@SpringBootApplication
public class SpringStartApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringStartApplication.class, args);
	}
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student("Akshat",21);
		Exam exam1 = new Exam("M","A");
		Exam exam2 = new Exam("P","C");
		student.getTests().add(exam2);
		student.getTests().add(exam1);
		
		this.studentRepo.save(student);

	}



}
