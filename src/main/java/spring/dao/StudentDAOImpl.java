package spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Student student) {
		sessionFactory.getCurrentSession().save(student);
		return student.getId();
	}

	@Override
	public Student get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> list() {
		List<Student> list = sessionFactory.getCurrentSession().createQuery("from Student").list();
		return list;
	}

	@Override
	public void update(long id, Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
