package collegefest.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import collegefest.model.Student;

public class CollegeFestMain {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// StudentService studentService = new StudentServiceImpl(sessionFactory);

//		SavedRequest students
//		// List<Student> students = null;
//		Student s1 = new Student("Suresh", "B.Tech", "India");
//		Student s2 = new Student("Muri", "B.Arch", "Canada");
//		Student s3 = new Student("Daniel", "B.Tech", "New Zealand");
		// Student s4 = new Student("Tanya", "B.Com", "India");
//		students.add(s1);
//		students.add(s2);
//		students.add(s3);
//		students.add(s4);
		// studentService.saveStudent(s1);
		// studentService.saveStudent(s2);
		// studentService.saveStudent(s3);
//		studentService.saveStudent(s4);

		// Delete student
//		studentService.deleteStudent(5);

		// Update student
		// studentService.updateStudent(4, s4);

		// Get all students
		// studentService.getAllStudents();
	}

}
