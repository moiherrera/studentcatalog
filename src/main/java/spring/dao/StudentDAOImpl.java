package spring.dao;

import java.util.List;

import org.hibernate.Session;
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
		return sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public List<Student> list() {
		List<Student> list = sessionFactory.getCurrentSession().createQuery("from Student").list();
		return list;
	}

	@Override
	public void update(long id, Student student) {
		Session session = sessionFactory.getCurrentSession();
		Student pastStudent = session.byId(Student.class).load(id);
		pastStudent.setFirstName(student.getFirstName());
		pastStudent.setLastName(student.getLastName());
		pastStudent.setSsn(student.getSsn());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.byId(Student.class).load(id);
		session.delete(student);
	}

}
