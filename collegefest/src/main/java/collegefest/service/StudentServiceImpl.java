package collegefest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collegefest.model.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			this.session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<Student> getAllStudents() {
		Transaction txTransaction = session.beginTransaction();
		List<Student> students = session.createQuery("FROM Student").list();
		txTransaction.commit();
		System.out.println(students);
		return students;
	}

	@Transactional
	public void updateStudent(int student_id, Student student) {
		Transaction txTransaction = session.beginTransaction();
		Student std = session.get(Student.class, student_id);
		if (std != null) {
			std.setCountry(student.getCountry());
			std.setDepartment(student.getDepartment());
			std.setName(student.getName());
		}
		txTransaction.commit();
	}

	@Transactional
	public void deleteStudent(int student_id) {
		Transaction txTransaction = session.beginTransaction();
		Student std = session.get(Student.class, student_id);
		if (std != null) {
			session.delete(std);
		}
		txTransaction.commit();
	}

	@Transactional
	public void saveStudent(Student student) {
		Transaction txTransaction = session.beginTransaction();
//		if (students.size() > 0) {
//			for (Student stdStudent : students) {
//				session.save(stdStudent);
//			}
//		}
		session.save(student);
		txTransaction.commit();
	}

}
