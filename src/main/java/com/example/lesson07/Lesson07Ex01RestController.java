package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C(create) U(update) D(delete)
	
	// C : create, insert
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "김지현";
		String phoneNumber = "010-2323-4545";
		String email = "jeon@kakao.com";
		String dreamJob = "개발자";

		// insert 된 것을 객체로 반환
		// 지금 들어간 id 값도 getId()로 바로 꺼낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	
	// U : update
	@GetMapping("/2")
	public StudentEntity update() {
		// id:4 dreamJob을 변경
		
		// update 된 것을 객체로 반환
		return studentBO.updateStudentDreamJobById(4, "디자이너");
	}
	
	
	// D : delete
	@GetMapping("/3")
	public String delete() {	// delete는 객체 반환 X
		// id : 4
		studentBO.deleteStudentById(4);
		return "삭제 완료";
	}
}
