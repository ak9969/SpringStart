package com.akshat.springstart.Dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.akshat.springstart.model.Exam;
import com.akshat.springstart.model.Student;
public class Services implements ExternalServices{
	@Autowired
	private StudentRepo studentRepo;
	@Override
	public void createExamService(Integer id,Exam exam) {
    	Student student = studentRepo.findByid(id);
    	if(student!=null) {
    		student.getTests().add(exam);
    		studentRepo.save(student);
    	}
	}

	@Override
	public Set<Student> topStudentService(List<Student> student,String test){
		
		System.out.println(student);
			Set<Student> top = new HashSet<>();
			student.forEach(studentObj->{
				if(!studentObj.getTests().isEmpty()) {
					studentObj.getTests().forEach(currTest->{
						if(currTest.getCourseName().equals(test)) {
							if(currTest.getMarks().equalsIgnoreCase("A")) {
								top.add(studentObj);
							}
						}
					});
				}
			});
			return top;
		
		
	}
}
