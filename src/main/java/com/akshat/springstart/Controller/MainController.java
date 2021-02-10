package com.akshat.springstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshat.springstart.Dao.Services;
import com.akshat.springstart.Dao.StudentRepo;
import java.util.*;

import javax.validation.Valid;

import com.akshat.springstart.model.*;
@RestController
@RequestMapping("/users")
public class MainController {
	
	@Autowired
	private StudentRepo studentRepo;
	private Services serviecs = new Services();

	@GetMapping(value="/student/all")
	public List<Student> findAll(){
		return  studentRepo.findAll();
	}

	@GetMapping("/{test}")
		public Set<Student> getTopStudent(@PathVariable String test){
		System.out.print(test);
			return serviecs.topStudentService(findAll(),test);
		}
	
    @PostMapping("/student")
    public Student createPost(@Validated @RequestBody Student student) {
    	
        return studentRepo.save(student);
    }
    @PostMapping("student/{Id}/test")
    public void createExam(@PathVariable (value = "Id") Integer Id,
    		@Valid @RequestBody Exam exam) { 
		serviecs.createExamService(Id, exam);
    }
    @PutMapping("student/{Id}")
    public Student updateStudent(@PathVariable Integer Id, 
    		@Valid @RequestBody Student updatedStudent) {
    	Student student = studentRepo.findByid(Id);
    	student.setAge(updatedStudent.getAge());
    	student.setName(updatedStudent.getName());
    	studentRepo.save(student);
    	return student;
    }
    
	@DeleteMapping("student/{Id}")
	public void deletePost(@PathVariable Integer Id) {
		Student student = studentRepo.findByid(Id);
		studentRepo.delete(student);
	}
}
