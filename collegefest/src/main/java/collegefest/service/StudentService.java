package collegefest.service;

import java.util.List;

import collegefest.model.Student;

public interface StudentService {

	public List<Student> getAllStudents();

	public void updateStudent(int student_id, Student student);

	public void deleteStudent(int student_id);

	public void saveStudent(Student student);

}
