package spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.StudentDAO;
import spring.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public long save(Student student) {
		return studentDAO.save(student);
	}

	@Override
	@Transactional
	public Student get(long id) {
		return studentDAO.get(id);
	}

	@Override
	@Transactional
	public List<Student> list() {
		return studentDAO.list();
	}

	@Override
	@Transactional
	public void update(long id, Student student) {
		studentDAO.update(id, student);
	}

	@Override
	@Transactional
	public void delete(long id) {
		studentDAO.delete(id);
	}

}
