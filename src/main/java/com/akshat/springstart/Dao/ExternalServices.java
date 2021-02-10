package com.akshat.springstart.Dao;

import java.util.*;

import com.akshat.springstart.model.Exam;
import com.akshat.springstart.model.Student;
/* Interface for all the external services based on requirement 
 * and not provided by JpaRepository CRUD operation
*/
public interface ExternalServices {
	void createExamService(Integer Id,Exam exam);
	Set<Student> topStudentService(List<Student> student,String test);
}
