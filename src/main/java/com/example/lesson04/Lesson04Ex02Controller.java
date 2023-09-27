package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 정보 추가 화면
	// 요청 URL : http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 가입 처리 후 가입된 사람 정보 뿌려주기
	// 요청 URL : http://localhost/lesson04/ex02/add-student
	// 가입된 사람의 정보를 객체로 받아올 것임
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student,		// jsp 파일의 name 속성과 일치하는 Student 객체의 필드에 매핑된다.
			Model model) {
		
		// DB Insert
		studentBO.addStudent(student);
		
		// DB Select => 방금 전에 가입된 사람 select하기; MyBatis에 포함된 기능 (xml에서 insert 태그에 useGeneratedKeys 속성 추가)
//		int id = student.getId();
		Student latestStudent = studentBO.getStudentById(student.getId());
		model.addAttribute("student", latestStudent);
		return "lesson04/afterAddStudent";
	}

}
