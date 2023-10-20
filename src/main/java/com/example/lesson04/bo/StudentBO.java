package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;	// myBatis
	
	@Autowired
	private StudentRepository studentRepository;	// JPA
	
	// myBatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input : id
	// output : 객체를 return
	public Student getStudentById(int id) {
		return studentMapper.selectStudent(id);
	}
	
	// JPA
	// input : params
	// output : StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber,
			String email, String dreamJob) {
		
		// 빌더 패턴 사용
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now())	// @UpdateTimestamp가 있다면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
}
