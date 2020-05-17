package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.model.Student;
import spring.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//Get all the students
	@GetMapping("/api/student")
	public ResponseEntity<List<Student>> list(){
		List<Student> list = studentService.list();
		return ResponseEntity.ok().body(list);
	}
}
