package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString	// 객체를 출력할 때 모든 내용이 보여진다.(무조건 붙이기)
@AllArgsConstructor		// 파라미터가 모두 있는 생성자 생성
@NoArgsConstructor		// 파라미터가 없는 기본 생성자 생성
@Getter
@Builder(toBuilder=true)	// setter의 대용, toBuilder=true : 수정 허용
@Entity(name="new_student")		// 이 객체는 엔티티라고 선언 (JPA-DB와 통신 사이)
@Table(name="new_student")
public class StudentEntity {

	// 필드
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp	// 시간을 넣지 않아도 현재 시간으로 자동으로 들어감(mySql의 NOW() 역할)
	@Column(name = "createdAt", updatable = false)	// updatable = false : 업데이트시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;
}
