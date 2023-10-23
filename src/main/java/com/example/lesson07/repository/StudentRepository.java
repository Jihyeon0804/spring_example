package com.example.lesson07.repository;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	//	Spring Data JPA : JpaRepository<불려질 entity, pk의 타입>
	
		// save() - insert, update ; parameter에 id가 있다면 update
		// findById() - select
		// delete(객체) - delete
		// findAll - 전체 조회
	
	
	// JPQL 문법 - ex02/1
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> names);
	
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	public List<StudentEntity> findByEmailContaining(String email);
	
	public List<StudentEntity> findByNameStartingWith(String name);
	
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	
	
	// ex02/2
	// 1) JPQL Entity로 조회 - DB에 접근하지 않고 Entity로 조회
//	@Entity(name="new_student")를 설정하지 않았으면 ... from StudentEntity st where ... 로 value 지정해야함
	@Query(value = "select st from new_student st where st.dreamJob = :dreamJob")
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
}