package collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import collegefest.model.Student;
import collegefest.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String getAllStudent(Model model) {
		List<Student> allStudents = studentService.getAllStudents();
		model.addAttribute("studentModel", allStudents);
		return "studentlist";
	}

	@GetMapping("/add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "savestudent";
	}

	@GetMapping("/update")
	public String updateStudent(@RequestParam Integer id, @RequestParam Student student, Model model) {
		studentService.updateStudent(id, student);
		model.addAttribute("student", id);
		return "savestudent";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam Integer id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}

	@GetMapping("/home")
	public String gotoHome() {
		return "redirect/";
	}

}