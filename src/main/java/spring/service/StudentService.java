package spring.service;

import java.util.List;

import spring.model.Student;

public interface StudentService {
	
	    //Save the record
		long save(Student student);
		
		//Get a single record
		Student get(long id);
		
		//Get all the records
		List<Student> list();
		
		//Update the record
		void update(long id, Student student);
		
		//Delete a record
		void delete(long id);
}
