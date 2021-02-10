package com.akshat.springstart.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshat.springstart.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{


	Student findByid(Integer id);

	
}
