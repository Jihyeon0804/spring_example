package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	// select
	// input : id
	// output : Review(단건)
	public Review selectReview(int id);
	
	
	// insert
	// return int는 MyBatis가 성공된 행의 개수를 리턴해준다. (MyBatis의 기능임)
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// @Param => 파라미터 2개 이상이면 map으로 만든다
			@Param("storeId") int storeId,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") Double point,
			@Param("review") String review);
}
