package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	// ---- select ----
	// input : params (name, phoneNumber, email, dreamJob)
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
	
	
	// ---- update ----
	// input : params(id, dreamJob)
	// output : 변경된 StudentEntity
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null);	// 해당하는 id가 없으면 null로 설정
		
		// student가 null이 아닌 경우에만 update
		if (student != null) {
			// 기존값은 유지하고 세팅된 일부의 값만 변경(dreamJob만 변경) => toBuilder
			student = student.toBuilder()		// 기존 값 유지
						.dreamJob(dreamJob)
						.build();
			
			// update
			student = studentRepository.save(student);	// db에 update 후 다시 select 된 결과
		}
		
		return student;		// null or 변경된 데이터
	}
	
	
	// ---- delete ----
	// input : id
	// output : X
	public void deleteStudentById(int id) {
		// 방법1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법2) - optional 객체 이용
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		// null이 아니라면(ifPresent)
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
