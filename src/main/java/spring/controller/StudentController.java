package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//Save the student
	@PostMapping("/api/student")
	public ResponseEntity<?> save(@RequestBody Student student){
		long id = studentService.save(student);
		return ResponseEntity.ok().body("Student created with id: " + id);
		
	}
	
	//Get a single record
	@GetMapping("/api/student/{id}")
	public ResponseEntity<Student> get(@PathVariable("id") long id){
		Student student = studentService.get(id);
		return ResponseEntity.ok().body(student);
	}
	
	//Update a student record
	@PutMapping("/api/student/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Student student){
		studentService.update(id, student);
		return ResponseEntity.ok().body("Student has been updated");
	}
	
	//Delete a student record
	@DeleteMapping("/api/student/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		studentService.delete(id);
		return ResponseEntity.ok().body("Student has been deleted");
	}
	
	
	
}
